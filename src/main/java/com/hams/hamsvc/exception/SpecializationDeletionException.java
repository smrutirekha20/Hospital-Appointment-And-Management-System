package com.hams.hamsvc.exception;

public class SpecializationDeletionException extends RuntimeException{
    private final String message;
    public SpecializationDeletionException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
