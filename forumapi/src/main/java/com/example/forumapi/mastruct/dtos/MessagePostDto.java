package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.Timestamp;

public class MessagePostDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long user_id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("topic_id")
    private Long topic_id;
}
