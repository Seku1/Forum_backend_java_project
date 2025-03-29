package com.example.forumapi.mastruct.mappers;

import com.example.forumapi.mastruct.dtos.*;
import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    MessageTopicDto toMessageTopicDto(Message message);

    MessageUserDto toMessageUserDto(Message message);

    TopicAllDto toTopicAllDto(Topic topic);

    UserGetDto toUserGetDto(User user);

    List<MessageTopicDto> authorsToMessageTopicDto(List<Message> messages);

    User userPostDto(UserPostDto userPostDto);
}
