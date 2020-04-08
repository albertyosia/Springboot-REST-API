package com.spring.restapi.module.employee;

import com.spring.restapi.models.GetResponseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeResponseModel extends GetResponseModel {
  private List<Employee> employees;
}
