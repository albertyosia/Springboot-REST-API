package com.spring.restapi;

public enum RestStatus {

  SUCCESS(700, "Success"),

  EMPLOYEE_NOT_FOUND(701, "Employee not found"),
  MANAGER_NOT_FOUND(702, "Manager not found"),
  DEPARTMENT_NOT_FOUND(703, "Department not found"),

  MAX_NAME_LENGTH_VIOLATION(801, "Name should not more than 10 character(s)"),

  MAX_EMAIL_LENGTH_VIOLATION(802, "Email should not more than 15 character(s)"),
  EMAIL_VIOLATION(803, "Email does not match pattern"),

  MAX_ADDRESS_LENGTH_VIOLATION(803, "Address should not more than 30 character(s)");

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
