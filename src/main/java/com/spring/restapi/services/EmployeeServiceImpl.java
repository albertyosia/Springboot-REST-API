package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.exceptions.UsernameNotFoundException;
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

  /**
   * This method is used to return all employee from database.
   * @return list of employee.
   */
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  /**
   * This method is used to add new employee to database.
   * @param newEmployee This is employee from request.
   * @return employee object.
   */
  @Override
  public Employee addEmployee(Employee newEmployee) {
    return employeeRepository.save(newEmployee);
  }

  /**
   * This method is used to update current employee.
   * @param currentEmployee This is employee to be updated.
   * @param employee This is employee from request.
   * @return employee object.
   */
  @Override
  public Employee updateEmployee(Employee currentEmployee, Employee employee) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(currentEmployee.getId());
    if (foundEmployee.isEmpty()) {
      throw new UsernameNotFoundException("Employee Id not found");
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

  /**
   * This method is used to delete employee.
   * @param employee This is employee to be deleted.
   */
  @Override
  public void deleteEmployee(Employee employee) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(employee.getId());
    if (foundEmployee.isEmpty()) {
      throw  new UsernameNotFoundException("Employee id not found");
    }
    employeeRepository.delete(employee);
  }
}
