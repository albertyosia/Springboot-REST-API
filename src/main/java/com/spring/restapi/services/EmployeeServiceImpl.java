package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
  public Employee updateEmployee(Employee currentEmployee, Employee employee) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(currentEmployee.getId());
    if (foundEmployee.isEmpty()) {
      throw new IllegalArgumentException("Employee Id not found");
    }
    if (!StringUtils.isEmpty(employee.getName())) {
      currentEmployee.setName(employee.getName());
    }
    if (!StringUtils.isEmpty(employee.getEmail())) {
      currentEmployee.setEmail(employee.getEmail());
    }
    if (!StringUtils.isEmpty(employee.getAddress())) {
      currentEmployee.setAddress(employee.getAddress());
    }
    return employeeRepository.save(currentEmployee);
  }

  @Override
  public void deleteEmployeeById(Long id) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(id);
    if (foundEmployee.isEmpty()) {
      throw  new IllegalArgumentException("Employee id not found");
    }
    employeeRepository.deleteById(id);
  }
}
