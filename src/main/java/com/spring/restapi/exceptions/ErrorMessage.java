package com.spring.restapi.exceptions;

import lombok.Data;

@Data
public class ErrorMessage {
  private int status;
  private String error;
  private String description;

  /**
   * This is constructor for ErrorMessage.
   * @param status This is status code.
   * @param error This is error message.
   * @param description This is error description.
   */
  public ErrorMessage(int status, String error, String description) {
    super();
    this.status = status;
    this.error = error;
    this.description = description;
  }
}
