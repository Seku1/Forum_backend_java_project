package com.example.forumapi.repositorytest;

import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import com.example.forumapi.repository.MessageRepository;
import com.example.forumapi.repository.TopicRepository;
import com.example.forumapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Test
    @Transactional
    @Rollback
    void testMessageRepositorySave() {
        User user = new User();

        user.setUsername("username");
        user.setPassword("password");
        userRepository.save(user);


        Topic topic = new Topic();
        topic.setTitle("title");
        topicRepository.save(topic);

        Message message = new Message();

        message.setTopic(topic);

        message.setUser(user);
        message.setContent("content");

        Instant timestamp = Instant.now();

        message.setTimestamp(timestamp);

        Message savedMessage = messageRepository.save(message);

        assertNotNull(savedMessage);

        assertEquals(savedMessage.getTopic(), message.getTopic());
        assertEquals(savedMessage.getUser(), message.getUser());
        assertEquals(savedMessage.getContent(), message.getContent());
        assertEquals(savedMessage.getTimestamp(), message.getTimestamp());
        assertEquals(savedMessage.getId(), message.getId());

    }

    @Test
    @Transactional
    @Rollback
    void testUserRepositoryFindById() {
        User user = new User();

        user.setUsername("username");
        user.setPassword("password");
        userRepository.save(user);


        Topic topic = new Topic();
        topic.setTitle("title");
        topicRepository.save(topic);

        Message message = new Message();

        message.setTopic(topic);

        message.setUser(user);
        message.setContent("content");

        Instant timestamp = Instant.now();

        message.setTimestamp(timestamp);

        messageRepository.save(message);

        Message foundMessage = messageRepository.findById(message.getId()).orElse(null);

        assertNotNull(foundMessage);

        assertEquals(foundMessage.getTopic(), message.getTopic());
        assertEquals(foundMessage.getUser(), message.getUser());
        assertEquals(foundMessage.getContent(), message.getContent());
        assertEquals(foundMessage.getTimestamp(), message.getTimestamp());
        assertEquals(foundMessage.getId(), message.getId());
    }
}
