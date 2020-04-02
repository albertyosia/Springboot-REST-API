package com.spring.restapi.services;

import com.spring.restapi.entities.Employee;
import com.spring.restapi.exceptions.UsernameNotFoundException;
import com.spring.restapi.models.EmployeesReturnModel;
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
  public EmployeesReturnModel getAllEmployees() {
    List<Employee> employeeList = employeeRepository.findAll();
    EmployeesReturnModel model = new EmployeesReturnModel();
    model.setCode(700);
    model.setStatus("success");
    model.setData(employeeList);
    return model;
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
   * @param id This is employee id to be updated.
   * @param employee This is employee from request.
   * @return employee object.
   */
  @Override
  public Employee updateEmployee(Long id, Employee employee) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(id);
    if (foundEmployee.isEmpty()) {
      throw new UsernameNotFoundException("Employee Id not found");
    }
    if (!StringUtils.isEmpty(employee.getName())) {
      foundEmployee.get().setName((employee.getName()));
    }
    if (!StringUtils.isEmpty(employee.getEmail())) {
      foundEmployee.get().setEmail(employee.getEmail());
    }
    if (!StringUtils.isEmpty(employee.getAddress())) {
      foundEmployee.get().setAddress(employee.getAddress());
    }
    return employeeRepository.save(foundEmployee.get());
  }

  /**
   * This method is used to delete employee.
   * @param id This is employee id to be deleted.
   */
  @Override
  public void deleteEmployee(Long id) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(id);
    if (foundEmployee.isEmpty()) {
      throw  new UsernameNotFoundException("Employee with id " + id + " not found");
    }
    employeeRepository.delete(foundEmployee.get());
  }
}
