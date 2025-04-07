package com.example.forumapi.repository;

import com.example.forumapi.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT t FROM Topic t LEFT JOIN FETCH t.messages WHERE t.id = :id")
    Optional<Topic> findByIdWithMessages(@Param("id") Long id);
}
