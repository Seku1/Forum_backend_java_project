package com.example.forumapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    public Topic() {}

    public Topic(String title) {
        this.title = title;
    }
}
