package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class UserPostDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("messages")
    private Set<MessageTopicDto>  messages;
}
