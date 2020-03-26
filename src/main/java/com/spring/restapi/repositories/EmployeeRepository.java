package com.spring.restapi.interfaces;

import com.spring.restapi.entities.Employee;

import java.util.List;

public interface EmployeeInterface {
    List<Employee> getAll();

    Employee findById(Long id);
}
