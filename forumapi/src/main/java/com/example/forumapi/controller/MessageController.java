package com.example.forumapi.controller;

import com.example.forumapi.mastruct.dtos.MessagePostDto;
import com.example.forumapi.mastruct.dtos.MessageTopicDto;
import com.example.forumapi.mastruct.mappers.MapStructMapper;
import com.example.forumapi.repository.MessageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Message")
public class MessageController {


    private MapStructMapper mapStructMapper;

    private MessageRepository messageRepository;

    @Autowired
    public MessageController(
            MapStructMapper mapStructMapper,
            MessageRepository messageRepository
    ) {
        this.mapStructMapper = mapStructMapper;
        this.messageRepository = messageRepository;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @Valid @RequestBody MessagePostDto messagePostDto
    ){
        messageRepository.save(
                mapStructMapper.messagePostDtoToMessage(messagePostDto)
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageTopicDto> getMessage(
            @PathVariable(value = "id") Long id
    ){
        return new ResponseEntity<>(
                mapStructMapper.messageToMessageTopicDto(
                        messageRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }
}
