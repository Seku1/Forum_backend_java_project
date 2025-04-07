package com.example.forumapi.mastruct.dtos;

import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
public class MessagePostDto {
    @JsonProperty("user")
    private User user;

    @JsonProperty("content")
    private String content;

    @JsonProperty("timestamp")
    private Instant timestamp;

    @JsonProperty("topic")
    private Topic topic;
}
