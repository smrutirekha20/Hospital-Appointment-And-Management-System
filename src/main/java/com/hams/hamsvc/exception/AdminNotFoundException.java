package com.hams.hamsvc.exception;

public class AdminNotFoundException extends RuntimeException {
   private final String message;
   public AdminNotFoundException(String message){
     this.message=message;
    }

  @Override
  public String getMessage(){
    return message;
  }
}
