package com.spring.restapi.controllers;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.services.EmployeeService;
import com.spring.restapi.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/register")
    public Employee registerEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Employee employee) {
         employeeService.deleteEmployee(employee);
    }
}
