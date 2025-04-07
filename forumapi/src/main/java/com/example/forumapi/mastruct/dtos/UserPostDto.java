package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostDto {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
