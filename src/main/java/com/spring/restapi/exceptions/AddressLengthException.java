package com.spring.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddressLengthException extends RuntimeException {
  public AddressLengthException(String message) {
    super(message, null);
  }
}
