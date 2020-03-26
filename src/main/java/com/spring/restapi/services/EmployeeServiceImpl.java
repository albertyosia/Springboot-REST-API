package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
    public Employee updateEmployee(Employee employee) {
        Employee foundEmployee = employeeRepository.findByName(employee.getName());
        Employee employeeToUpdate = new Employee();
        if(foundEmployee == null){
            HttpStatus.BAD_REQUEST.value();
        }
        if(!StringUtils.isEmpty(employee.getName())){
            employeeToUpdate.setName(employee.getName());
        }
        if(!StringUtils.isEmpty(employee.getEmail())){
            employeeToUpdate.setEmail(employee.getEmail());
        }
        if(!StringUtils.isEmpty(employee.getAddress())){
            employeeToUpdate.setAddress(employee.getAddress());
        }
        return employeeRepository.save(employeeToUpdate);
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
