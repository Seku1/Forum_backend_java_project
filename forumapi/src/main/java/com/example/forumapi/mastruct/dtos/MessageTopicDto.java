package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.Timestamp;

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
