package com.spring.restapi.module.employee;

import com.spring.restapi.models.SuccessResponseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeResponseModel extends SuccessResponseModel {
  private List<Employee> employees;
}
