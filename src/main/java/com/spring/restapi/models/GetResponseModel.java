package com.spring.restapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetResponseModel {
  private int code;
  private String status;
}
