package com.spring.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NameLengthException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public NameLengthException(String message) {
    super(message, null);
  }
}
