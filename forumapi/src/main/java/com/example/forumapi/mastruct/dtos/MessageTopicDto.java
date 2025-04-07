package com.example.forumapi.mastruct.dtos;

import com.example.forumapi.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MessageTopicDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private User user;

    @JsonProperty("content")
    private String content;

    @JsonProperty("timestamp")
    private Instant timestamp;
}
