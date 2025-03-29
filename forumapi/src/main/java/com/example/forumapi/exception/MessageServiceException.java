package com.example.forumapi.exception;

public class MessageServiceException extends RuntimeException {
    public MessageServiceException(String message) {
        super(message);
    }
}
