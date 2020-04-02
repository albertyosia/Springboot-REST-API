package com.spring.restapi.exceptions;

import lombok.Data;

@Data
public class ErrorMessage {
  private int status;
  private String error;
  private String description;

  public ErrorMessage(int status, String error, String description) {
    super();
    this.status = status;
    this.error = error;
    this.description = description;
  }
}
