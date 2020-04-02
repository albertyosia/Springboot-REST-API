package com.spring.restapi.models;

import com.spring.restapi.entities.Employee;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeesReturnModel {
  private int code;
  private String status;
  private List<Employee> data;
}
