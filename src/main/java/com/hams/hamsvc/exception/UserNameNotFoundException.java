package com.hams.hamsvc.exception;


public class UserNameNotFoundException extends RuntimeException {
    private final String message;
    public UserNameNotFoundException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}

