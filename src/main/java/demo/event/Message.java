package demo.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Message {
    @JsonProperty("date")
    private int date;
    @JsonProperty("from_id")
    private Long fromId;
    @JsonProperty("id")
    private int id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("peer_id")
    private Long peerId;
}