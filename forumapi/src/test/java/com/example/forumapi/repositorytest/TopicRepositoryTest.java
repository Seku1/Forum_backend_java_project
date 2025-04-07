package com.example.forumapi.repositorytest;


import com.example.forumapi.model.Topic;
import com.example.forumapi.repository.TopicRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class TopicRepositoryTest {
    @Autowired
    private TopicRepository topicRepository;

    @Test
    @Transactional
    @Rollback
    void testSaveTopic() {
        Topic topic = new Topic();

        topic.setTitle("title");

        Topic savedTopic = topicRepository.save(topic);

        assertEquals(savedTopic.getId(), topic.getId());

        assertEquals(savedTopic.getTitle(), topic.getTitle());
    }

    @Test
    @Transactional
    @Rollback
    void testFindById() {
        Topic topic = new Topic();
        topic.setTitle("title");

        topicRepository.save(topic);

        Topic foundTopic = topicRepository.findById(topic.getId()).orElse(null);

        assertNotNull(foundTopic);

        assertEquals(foundTopic.getTitle(), topic.getTitle());
    }

}
