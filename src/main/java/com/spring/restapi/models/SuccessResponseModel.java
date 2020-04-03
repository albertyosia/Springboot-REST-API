package com.spring.restapi.models;

import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.employee.Employee;
import com.spring.restapi.module.manager.Manager;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SuccessResponseModel {
  private int code;
  private String status;
  private List<Employee> employees;
  private List<Manager> managers;
  private List<Department> departments;
}
