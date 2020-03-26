package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Employee currEmployee, Employee employee) {
        Employee foundEmployee = employeeRepository.findOneById(employee.getId());
        if(foundEmployee == null){
            HttpStatus.BAD_REQUEST.value();
        }
        if(!StringUtils.isEmpty(employee.getName())){
            currEmployee.setName(employee.getName());
        }
        if(!StringUtils.isEmpty(employee.getEmail())){
            currEmployee.setEmail(employee.getEmail());
        }
        if(!StringUtils.isEmpty(employee.getAddress())){
            currEmployee.setAddress(employee.getAddress());
        }
        return employeeRepository.save(currEmployee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Employee foundEmployee = employeeRepository.findOneById(employee.getId());
        if(foundEmployee == null){
            HttpStatus.BAD_REQUEST.value();
        }
        employeeRepository.delete(foundEmployee);
    }
}
