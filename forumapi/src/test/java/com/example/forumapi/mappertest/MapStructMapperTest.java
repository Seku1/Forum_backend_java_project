package com.example.forumapi.mappertest;

import com.example.forumapi.mastruct.dtos.*;
import com.example.forumapi.mastruct.mappers.MapStructMapper;
import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import com.example.forumapi.repository.MessageRepository;
import com.example.forumapi.repository.TopicRepository;
import com.example.forumapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class MapStructMapperTest {
    @Qualifier("mapStructMapperImpl")
    @Autowired
    MapStructMapper mapper;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Test
    @Transactional
    @Rollback
    void testUserGetDto() {
        User user = new User();

        user.setUsername("username");
        user.setPassword("password");

        UserGetDto dto = mapper.userToUserGetDto(user);

        assertNotNull(dto);

        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getId(), dto.getId());
    }

    @Test
    @Transactional
    @Rollback
    void testUserPostDto() {
        UserPostDto dto = new UserPostDto();

        dto.setUsername("username");
        dto.setPassword("password");

        User user = mapper.userPostDtotoUser(dto);

        assertNotNull(user);
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getPassword(), dto.getPassword());
    }

    @Test
    @Transactional
    @Rollback
    void testMessagePostDto() {
        MessagePostDto dto = new MessagePostDto();

        Topic topic = new Topic();
        topic.setTitle("title");
        topicRepository.save(topic);

        User  user = new User();
        user.setUsername("username");
        user.setPassword("password");
        userRepository.save(user);


        dto.setContent("content");
        dto.setTimestamp(Instant.now());
        dto.setTopic(topic);
        dto.setUser(user);

        Message message = mapper.messagePostDtoToMessage(dto);

        assertNotNull(message);
        assertEquals(message.getContent(), dto.getContent());
        assertEquals(message.getTimestamp(), dto.getTimestamp());
        assertEquals(message.getTopic(), dto.getTopic());
        assertEquals(message.getUser(), dto.getUser());
    }


    @Test
    @Transactional
    @Rollback
    void testMessageGetDto() {
        User  user = new User();
        user.setUsername("username");
        user.setPassword("password");
        userRepository.save(user);

        Topic topic = new Topic();
        topic.setTitle("title");
        topicRepository.save(topic);

        Message message = new Message();
        message.setContent("content");
        message.setTimestamp(Instant.now());
        message.setUser(user);
        message.setTopic(topic);
        messageRepository.save(message);

        MessageTopicDto dto = mapper.messageToMessageTopicDto(message);

        assertNotNull(dto);
        assertEquals(message.getContent(), dto.getContent());
        assertEquals(message.getTimestamp(), dto.getTimestamp());
        assertEquals(user.getId(), dto.getUser().getId());
    }

    @Test
    @Transactional
    @Rollback
    void testTopicSimpleDto() {
        Topic topic1 = new Topic();
        topic1.setTitle("title1");
        topicRepository.save(topic1);

        Topic topic2 = new Topic();
        topic2.setTitle("title2");
        topicRepository.save(topic2);

        List<Topic> topics = List.of(topic1, topic2);

        List<TopicSimpleDto> dtos = mapper.topicToTopicSimpleDto(topics);

        assertNotNull(dtos);
        assertEquals(topics.size(), dtos.size());

        assertEquals(topic1.getId(), dtos.get(0).getId());
        assertEquals(topic2.getId(), dtos.get(1).getId());
        assertEquals(topic1.getTitle(), dtos.get(0).getTitle());
        assertEquals(topic2.getTitle(), dtos.get(1).getTitle());
    }

    @Test
    @Transactional
    @Rollback
    void testTopicMessagesDto() {
        User user = new User();
        user.setUsername("username1");
        user.setPassword("password1");
        userRepository.save(user);

        Topic topic = new Topic();
        topic.setTitle("title1");
        topicRepository.save(topic);

        Message message1 = new Message();
        message1.setContent("content1");
        message1.setTimestamp(Instant.now());
        message1.setTopic(topic);
        topic.getMessages().add(message1);
        message1.setUser(user);
        messageRepository.save(message1);

        Message message2 = new Message();
        message2.setContent("content2");
        message2.setTimestamp(Instant.now());
        message2.setTopic(topic);
        topic.getMessages().add(message2);
        message2.setUser(user);
        messageRepository.save(message2);

        topic = topicRepository.findByIdWithMessages(topic.getId()).get();

        TopicMessagesDto dto = mapper.topicToTopicMessagesDto(topic);

        assertNotNull(dto);
        assertNotNull(dto.getMessages());
        assertEquals(2, dto.getMessages().size());
        assertEquals(topic.getTitle(), dto.getTitle());
    }

}
