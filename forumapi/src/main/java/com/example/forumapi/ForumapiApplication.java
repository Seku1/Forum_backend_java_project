package com.example.forumapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.forumapi.repository")
@EntityScan(basePackages = {"com.example.forumapi.model"})
public class ForumapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumapiApplication.class, args);
    }

}
