package com.hams.hamsvc.exception;

public class DoctorNotFoundException extends RuntimeException{
    private final String message;

    public DoctorNotFoundException(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
