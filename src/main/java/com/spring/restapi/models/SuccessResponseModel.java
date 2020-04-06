package com.spring.restapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuccessResponseModel {
  private int code;
  private String status;
}
