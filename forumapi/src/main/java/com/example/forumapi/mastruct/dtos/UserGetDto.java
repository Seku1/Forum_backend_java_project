package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserGetDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;
}
