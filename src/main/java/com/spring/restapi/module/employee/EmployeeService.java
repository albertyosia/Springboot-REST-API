package com.spring.restapi.module.employee;

import com.spring.restapi.models.SuccessResponseModel;

public interface EmployeeService {
  SuccessResponseModel getAllEmployees();

  Employee addEmployee(Employee employee);

  Employee updateEmployee(Long id, Employee employee);

  void deleteEmployee(Long id);
}
