package demo.response;

import demo.Constants;
import demo.event.Event;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class ReplyMessage extends Response {

    public ReplyMessage(String accessToken, Event event) {
        super(accessToken, event);
    }

    @Override
    public List<NameValuePair> getQueryParameters() {
        List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("message", "Вы сказали: " + getEvent().getEventObject().getMessage().getText()));
        params.add(new BasicNameValuePair("peer_id", super.getEvent().getEventObject().getMessage().getPeerId().toString()));
        params.add(new BasicNameValuePair("access_token", super.getAccessToken()));
        params.add(new BasicNameValuePair("v", Constants.VK_API_VERSION));

        return params;
    }
}
