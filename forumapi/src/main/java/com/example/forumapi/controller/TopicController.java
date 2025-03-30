package com.example.forumapi.controller;

import com.example.forumapi.mastruct.dtos.TopicSimpleDto;
import com.example.forumapi.mastruct.dtos.TopicMessagesDto;
import com.example.forumapi.mastruct.mappers.MapStructMapper;
import com.example.forumapi.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Topics")
public class TopicController {

    private MapStructMapper mapStructMapper;

    private TopicRepository topicRepository;

    @Autowired
    public TopicController(
            TopicRepository topicRepository,
            MapStructMapper mapStructMapper
    ) {
        this.topicRepository = topicRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @Valid @RequestBody TopicSimpleDto topicSimpleDto
    ){
        topicRepository.save(
                mapStructMapper.topicAllDtoToTopic(topicSimpleDto)
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TopicSimpleDto>> getAll(){
        return new ResponseEntity<>(
                mapStructMapper.topicToTopicSimpleDto(
                        topicRepository.findAll()
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/id")
    public ResponseEntity<TopicMessagesDto> getById(
            @Valid @RequestParam Long id
    ){
        return new ResponseEntity<>(
                mapStructMapper.topicToTopicMessagesDto(
                        topicRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }
}
