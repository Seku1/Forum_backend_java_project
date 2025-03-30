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
    MessagePostDto messageToMessageDto(Message message);

    MessageTopicDto messageToMessageTopicDto(Message message);

    Message messagePostDtoToMessage(MessagePostDto messagePostDto);

    TopicMessagesDto topicToTopicMessagesDto(Topic topic);

    List<TopicSimpleDto> topicToTopicSimpleDto(List<Topic> topic);

    Topic topicAllDtoToTopic(TopicSimpleDto topicAllDto);

    UserGetDto userToUserGetDto(User user);

    List<MessagePostDto> authorsToMessageTopicDto(List<Message> messages);

    User userPostDtotoUser(UserPostDto userPostDto);

}
