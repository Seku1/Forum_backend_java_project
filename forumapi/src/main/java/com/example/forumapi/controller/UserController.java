package com.example.forumapi.controller;

import com.example.forumapi.mastruct.dtos.UserGetDto;
import com.example.forumapi.mastruct.dtos.UserPostDto;
import com.example.forumapi.mastruct.mappers.MapStructMapper;
import com.example.forumapi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {

    private MapStructMapper mapStructMapper;

    private UserRepository userRepository;

    @Autowired
    public UserController(
            MapStructMapper mapStructMapper,
            UserRepository userRepository
    ){
        this.mapStructMapper = mapStructMapper;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<Void> create(
            @Valid @RequestBody UserPostDto userPostDto
    ){
        userRepository.save(
                mapStructMapper.userPostDtotoUser(userPostDto)
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserGetDto> getById(
            @PathVariable(value = "id") Long id
    ){
        return new ResponseEntity<>(
                mapStructMapper.userToUserGetDto(
                        userRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }
}
