package com.spring.restapi.exceptions;

import com.spring.restapi.RestStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * This method is used to handle username not found exception.
   * @param ex This is exception.
   * @param request from web.
   * @return response entity.
   */
  @ExceptionHandler(value = {UsernameNotFoundException.class})
  public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMPLOYEE_NOT_FOUND.getMessage();
    int errorCode = RestStatus.EMPLOYEE_NOT_FOUND.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {NullNameException.class})
  public final ResponseEntity<Object> handleNullNameException(NullNameException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.NAME_REQUIRED.getMessage();
    int errorCode = RestStatus.NAME_REQUIRED.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {NameLengthException.class})
  public final ResponseEntity<Object> handleNameLengthException(NameLengthException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.NAME_LENGTH_VIOLATION.getMessage();
    int errorCode = RestStatus.NAME_LENGTH_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {NullEmailException.class})
  public final ResponseEntity<Object> handleNullEmailException(NullEmailException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMAIL_REQUIRED.getMessage();
    int errorCode = RestStatus.EMAIL_REQUIRED.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {EmailLengthException.class})
  public final ResponseEntity<Object> handleEmailLengthException(EmailLengthException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMAIL_LENGTH_VIOLATION.getMessage();
    int errorCode = RestStatus.EMAIL_LENGTH_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {NullAddressException.class})
  public final ResponseEntity<Object> handleNullAddressException(NullAddressException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.ADDRESS_REQUIRED.getMessage();
    int errorCode = RestStatus.ADDRESS_REQUIRED.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {AddressLengthException.class})
  public final ResponseEntity<Object> handleAddressLengthException(AddressLengthException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.ADDRESS_LENGTH_VIOLATION.getMessage();
    int errorCode = RestStatus.ADDRESS_LENGTH_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
