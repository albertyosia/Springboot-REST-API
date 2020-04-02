package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.models.EmployeesReturnModel;

public interface EmployeeService {
  EmployeesReturnModel getAllEmployees();

  Employee addEmployee(Employee employee);

  Employee updateEmployee(Long id, Employee employee);

  void deleteEmployee(Long id);
}
