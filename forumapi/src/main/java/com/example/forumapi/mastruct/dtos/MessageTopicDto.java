package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
public class MessageTopicDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long user_id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("timestamp")
    private Timestamp timestamp;
}
