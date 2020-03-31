package com.spring.restapi.exceptions;

public class UsernameNotFound extends Exception {
  private String message;
    
  public UsernameNotFound(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
