package com.spring.restapi.exceptions;

public enum RestStatus {

  SUCCESS(700, "Success"),

  EMPLOYEE_NOT_FOUND(701, "Employee not found"),
  MANAGER_NOT_FOUND(702, "Manager not found"),
  DEPARTMENT_NOT_FOUND(703, "Department not found"),

  NAME_REQUIRED(706, "Name required"),
  NAME_LENGTH_VIOLATION(707, "Name length violation"),

  EMAIL_REQUIRED(708, "Email required"),
  EMAIL_LENGTH_VIOLATION(709, "Email length violation"),
  EMAIL_PATTERN_VIOLATION(800, "Email does not match pattern"),

  ADDRESS_REQUIRED(801, "Address required"),
  ADDRESS_LENGTH_VIOLATION(802, "Address length violation");

  private int code;

  private String message;

  RestStatus(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
