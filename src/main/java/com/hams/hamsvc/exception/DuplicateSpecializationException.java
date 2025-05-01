package com.hams.hamsvc.exception;

public class DuplicateSpecializationException extends RuntimeException {
 private final String message;

  public DuplicateSpecializationException(String message) {
    this.message = message;
  }
  public String getMessage(){
    return message;
  }
}