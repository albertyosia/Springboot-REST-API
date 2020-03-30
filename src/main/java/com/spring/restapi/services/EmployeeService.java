package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.exceptions.UsernameNotFound;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee currEmployee, Employee employee);

    Optional<Employee> deleteEmployee(Employee employee);

}
