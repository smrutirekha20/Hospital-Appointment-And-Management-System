package com.hams.hamsvc.exception;

public class SpecializationNotFoundException extends RuntimeException {
  private final String message;
  public SpecializationNotFoundException(String message) {
    this.message=message;
  }

  @Override
  public String getMessage(){
    return message;
  }
  }

