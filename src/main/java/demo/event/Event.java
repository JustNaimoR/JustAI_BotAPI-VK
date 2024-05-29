package demo.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Event - входящие данные от VK при определенных действиях в чате группы
 *      *введенное сообщение лежит в eventObject.message.text при type = message_new
 */

@Getter
public class Event {
    @JsonProperty("group_id")
    private Long groupId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("object")
    private EventObject eventObject;

    @JsonProperty("secret")
    private String secret;

    @Override
    public String toString() {
        return "Event [groupId=" + groupId + ", type=" + type + ", eventId=" + eventId + "]";
    }
}