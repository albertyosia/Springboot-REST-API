package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Employee currEmployee, Employee employee){
        Optional<Employee> foundEmployee = employeeRepository.findOneById(employee.getId());
        if(!foundEmployee.isPresent()){
            throw new IllegalArgumentException("Employee Id not found");
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
        Optional<Employee> foundEmployee = employeeRepository.findOneById(employee.getId());
        if(!foundEmployee.isPresent()){
            throw new IllegalArgumentException("Employee Id not found");
        }
        employeeRepository.delete(employee);
    }
}
