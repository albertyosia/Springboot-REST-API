package com.spring.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeContainScriptException extends RuntimeException {
  public AttributeContainScriptException(String message) {
    super(message, null);
  }
}
