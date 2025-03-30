package com.example.forumapi.mastruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicSimpleDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;
}
