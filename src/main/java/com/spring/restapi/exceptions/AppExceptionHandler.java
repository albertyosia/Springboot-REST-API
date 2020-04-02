package com.spring.restapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {UsernameNotFoundException.class})
  public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = "Employee not found";
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(701, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
