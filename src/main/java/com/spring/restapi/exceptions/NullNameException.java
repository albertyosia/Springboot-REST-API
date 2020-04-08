package com.spring.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NullNameException extends RuntimeException {
  public NullNameException(String message) {
    super(message, null);
  }
}
