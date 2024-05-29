package demo.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
public class EventObject {
    @JsonProperty("message")
    private Message message;
    @JsonProperty("client_info")            // ненужные данные
    private Map<String, Object> clientInfo;
}