package com.spring.restapi.module.employee;

import java.util.List;
import org.springframework.data.domain.Page;

public interface EmployeeService {
  EmployeeResponseModel getAllEmployees();

  List<Employee> getFiveEmployee();

  List<Employee> getFiveEmployeeOrderByName();

  List<Employee> getFiveEmployeeSortByDescending();

  Page<Employee> getPageableEmployee(Integer page, Integer size);

  Employee addEmployee(Employee employee);

  Employee updateEmployee(Long id, Employee employee);

  void deleteEmployee(Long id);
}
