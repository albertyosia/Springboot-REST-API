package com.spring.restapi.controllers;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired private EmployeeService employeeService;

  @GetMapping("/")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @PostMapping("/")
  public Employee registerEmployee(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @PutMapping("/{id}")
  public Employee updateEmployee(@PathVariable("id") Employee currEmployee,
                                 @RequestBody Employee employee) {
    return employeeService.updateEmployee(currEmployee, employee);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable("id") Employee employee) {
    employeeService.deleteEmployee(employee.getId());
  }
}
