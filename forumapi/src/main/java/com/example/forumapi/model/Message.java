package com.example.forumapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Entity
@Getter
@Setter
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Instant timestamp;

    public Message() {}

    public Message(User user, Topic topic, String content, Instant timestamp) {
        this.user = user;
        this.topic = topic;
        this.content = content;
        this.timestamp = timestamp;
    }
}
