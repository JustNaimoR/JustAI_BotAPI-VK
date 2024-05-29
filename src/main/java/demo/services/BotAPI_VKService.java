package demo.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.Constants;
import demo.config.BotConfig;
import demo.event.Event;
import demo.exceptions.IncorrectSecretException;
import demo.exceptions.SendResponseException;
import demo.response.Response;
import demo.response.ReplyMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class BotAPI_VKService {
    private BotConfig config;

    public String respond(Event event) {
        // игнорирую логирование reply event (в данном случе они лишь засоряют вывод)
        if (!event.getType().equals(Constants.CALLBACK_API_EVENT_MESSAGE_REPLAY))
            log.info("Responding to {}", event);

        if (!event.getSecret().equals(config.getSecret()))
            throw new IncorrectSecretException();

        if (event.getType().equals(Constants.CALLBACK_API_EVENT_CONFIRMATION)) {
            log.info("Received event is confirmation");

            return config.getSecret();
        } else if (event.getType().equals(Constants.CALLBACK_API_EVENT_MESSAGE_NEW)) {
            log.info("Received event is a message: {}", event.getEventObject().getMessage().getText());

            sendResponse(new ReplyMessage(config.getAccess(), event));
        }

        return "ok";
    }

    public void sendResponse(Response response) {
        try (CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
                .build()) {

            HttpGet httpGet = new HttpGet(Constants.VK_API_ENDPOINT + Constants.VK_API_METHOD_MESSAGE_SEND);
            httpGet.setURI(new URIBuilder(httpGet.getURI()).addParameters(response.getQueryParameters()).build());

            CloseableHttpResponse clientResponse = client.execute(httpGet);     // Выполнили отправку ответа

            HttpEntity entity = clientResponse.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            JsonNode jsonNode = new ObjectMapper().readTree(responseString);

            checkErrors(jsonNode.path("error"));
        } catch (Exception ex) {
            throw new SendResponseException(ex);
        }
    }

    private void checkErrors(JsonNode jsonNode) {
        if (!jsonNode.isEmpty()) {
            log.error("Received an error: '" + jsonNode.path("error_msg").asText() +
                    "' with code [" + jsonNode.path("error_code").asText() + "]\n" +
                    "The following request parameters were passed:\n" +
                    jsonNode.path("request_params").toPrettyString());
        }
    }
}