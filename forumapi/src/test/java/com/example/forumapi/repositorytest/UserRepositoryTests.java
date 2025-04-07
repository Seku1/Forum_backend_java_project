package com.example.forumapi.repositorytest;

import com.example.forumapi.model.User;
import com.example.forumapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback
    void testSaveUser() {
        User user = new User();

        user.setUsername("username");
        user.setPassword("password");
        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);

        assertNotNull(savedUser.getId());

        assertEquals(user.getUsername(), savedUser.getUsername());

        assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    @Transactional
    @Rollback
    void testFindById() {
        User user = new User();

        user.setUsername("username");
        user.setPassword("password");

        userRepository.save(user);

        User foundUser = userRepository.findById(user.getId()).orElse(null);

        assertNotNull(foundUser);

        assertEquals(user.getUsername(), foundUser.getUsername());

        assertEquals(user.getPassword(), foundUser.getPassword());
    }

    @Test
    @Transactional
    @Rollback
    void testFindByIdNotFound() {
        Long id = Long.MAX_VALUE;

        User foundUser = userRepository.findById(id).orElse(null);

        assertNull(foundUser);
    }

}
