package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee currEmployee, Employee employee);

    void deleteEmployee(Employee employee);

}
