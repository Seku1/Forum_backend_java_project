package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
public class MessageUserDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("topic_id")
    private Long topicId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("timestamp")
    private Timestamp timestamp;
}
