package com.spring.restapi.module.employee;

public interface EmployeeService {
  EmployeeResponseModel getAllEmployees();

  Employee addEmployee(Employee employee);

  Employee updateEmployee(Long id, Employee employee);

  void deleteEmployee(Long id);
}
