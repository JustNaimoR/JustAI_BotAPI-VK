package demo.response;

import demo.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.NameValuePair;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Response {
    private String accessToken;
    private Event event;

    public abstract List<NameValuePair> getQueryParameters();
}