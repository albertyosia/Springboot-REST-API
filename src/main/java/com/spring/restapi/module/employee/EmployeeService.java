package com.spring.restapi.module.employee;

import java.util.List;
import org.springframework.data.domain.Page;

public interface EmployeeService {
  EmployeeResponseModel getAllEmployees();

  List<Employee> getFiveEmployee();

  List<Employee> getFiveEmployeeOrderByName();

  List<Employee> getFiveEmployeeSortByDescending();

  Page<Employee> getPageableEmployee(int page, int size);

  Employee getGeneratedEmployee(Employee employee);

  Employee getUpdatedEmployee(Long id, Employee employee);

  void deleteEmployee(Long id);
}
