package com.spring.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NullAddressException extends RuntimeException{
  public NullAddressException(String message) {
    super(message, null);
  }
}
