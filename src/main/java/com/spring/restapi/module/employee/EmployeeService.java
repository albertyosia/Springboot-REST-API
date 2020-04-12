package com.spring.restapi.module.employee;

import java.util.List;

public interface EmployeeService {
  EmployeeResponseModel getAllEmployees();

  List<Employee> getEmployees();

  List<Employee> getEmployeesOrderByName();

  List<Employee> getEmployeesSortByDescending();

  Employee addEmployee(Employee employee);

  Employee updateEmployee(Long id, Employee employee);

  void deleteEmployee(Long id);
}
