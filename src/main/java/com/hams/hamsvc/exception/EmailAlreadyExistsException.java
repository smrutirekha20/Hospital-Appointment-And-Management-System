package com.hams.hamsvc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;


public class EmailAlreadyExistsException extends RuntimeException{
    private final String message;
    public EmailAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
