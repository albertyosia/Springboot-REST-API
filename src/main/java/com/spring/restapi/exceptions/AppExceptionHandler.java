package com.spring.restapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * This method is used to handle username not found exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {UsernameNotFoundException.class})
  public final ResponseEntity<Object> handleUsernameNotFoundException(
      UsernameNotFoundException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMPLOYEE_NOT_FOUND.getMessage();
    int errorCode = RestStatus.EMPLOYEE_NOT_FOUND.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * This method is used to handle null name  exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {NullNameException.class})
  public final ResponseEntity<Object> handleNullNameException(
      NullNameException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.NAME_REQUIRED.getMessage();
    int errorCode = RestStatus.NAME_REQUIRED.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method is used to handle name length exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {NameLengthException.class})
  public final ResponseEntity<Object> handleNameLengthException(
      NameLengthException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.NAME_LENGTH_VIOLATION.getMessage();
    int errorCode = RestStatus.NAME_LENGTH_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method is used to handle null email exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {NullEmailException.class})
  public final ResponseEntity<Object> handleNullEmailException(
      NullEmailException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMAIL_REQUIRED.getMessage();
    int errorCode = RestStatus.EMAIL_REQUIRED.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method is used to handle email length exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {EmailLengthException.class})
  public final ResponseEntity<Object> handleEmailLengthException(
      EmailLengthException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMAIL_LENGTH_VIOLATION.getMessage();
    int errorCode = RestStatus.EMAIL_LENGTH_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method is used to handle email pattern exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {EmailPatternException.class})
  public final ResponseEntity<Object> handleEmailPatternException(
      EmailPatternException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.EMAIL_PATTERN_VIOLATION.getMessage();
    int errorCode = RestStatus.EMAIL_PATTERN_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * This method is used to handle null address exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {NullAddressException.class})
  public final ResponseEntity<Object> handleNullAddressException(
      NullAddressException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.ADDRESS_REQUIRED.getMessage();
    int errorCode = RestStatus.ADDRESS_REQUIRED.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method is used to handle address length exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {AddressLengthException.class})
  public final ResponseEntity<Object> handleAddressLengthException(
      AddressLengthException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.ADDRESS_LENGTH_VIOLATION.getMessage();
    int errorCode = RestStatus.ADDRESS_LENGTH_VIOLATION.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method is used to handle department not found exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {DepartmentNotFoundException.class})
  public final ResponseEntity<Object> handleDepartmentNotFoundException(
      DepartmentNotFoundException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.DEPARTMENT_NOT_FOUND.getMessage();
    int errorCode = RestStatus.DEPARTMENT_NOT_FOUND.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * This method is used to handle manager not found exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {ManagerNotFoundException.class})
  public final ResponseEntity<Object> handleManagerNotFoundException(
      ManagerNotFoundException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.MANAGER_NOT_FOUND.getMessage();
    int errorCode = RestStatus.MANAGER_NOT_FOUND.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * This method is used to handle manager not found exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {AttributeContainScriptException.class})
  public final ResponseEntity<Object> handleAttributeContainScriptException(
      AttributeContainScriptException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.ATTRIBUTE_CONTAIN_SCRIPT.getMessage();
    int errorCode = RestStatus.ATTRIBUTE_CONTAIN_SCRIPT.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * This method is used to handle role not found exception.
   * @param ex This is exception.
   * @return response entity.
   */
  @ExceptionHandler(value = {RoleNotFoundException.class})
  public final ResponseEntity<Object> handleRoleNotFoundException(
      AttributeContainScriptException ex) {
    String errorMessageDescription = ex.getLocalizedMessage();
    String errorMessage = RestStatus.ROLE_NOT_FOUND.getMessage();
    int errorCode = RestStatus.ROLE_NOT_FOUND.getCode();
    if (errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    ErrorMessage message = new ErrorMessage(errorCode, errorMessage, errorMessageDescription);
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
