package com.spring.restapi.module.employee;

import com.spring.restapi.RestStatus;
import com.spring.restapi.exceptions.UsernameNotFoundException;
import com.spring.restapi.models.SuccessResponseModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;
  private final Integer MAX_NAME_LENGTH = 10;
  private final Integer MAX_EMAIL_LENGTH = 15;
  private final Integer MAX_ADDRESS_LENGTH = 30;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  /**
   * This method is used to return all employee from database.
   * @return list of employee.
   */
  public SuccessResponseModel getAllEmployees() {
    List<Employee> employees = employeeRepository.findAll();
    SuccessResponseModel model = new SuccessResponseModel();
    model.setCode(RestStatus.SUCCESS.getCode());
    model.setStatus(RestStatus.SUCCESS.getMessage());
    model.setEmployees(employees);
    return model;
  }

  /**
   * This method is used to add new employee to database.
   * @param newEmployee This is employee from request.
   * @return employee object.
   */
  @Override
  @Transactional
  public Employee addEmployee(Employee newEmployee) {
    if (MAX_NAME_LENGTH < newEmployee.getEmployeeName().length()) {
      return null;
    }
    return employeeRepository.saveAndFlush(newEmployee);
  }

  /**
   * This method is used to update current employee.
   * @param id This is employee id to be updated.
   * @param employee This is employee from request.
   * @return employee object.
   */
  @Override
  @Transactional
  public Employee updateEmployee(Long id, Employee employee) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(id);
    if (foundEmployee.isEmpty()) {
      throw new UsernameNotFoundException("Employee with id " + id + " not found");
    }
    if (!StringUtils.isEmpty(employee.getEmployeeName())) {
      foundEmployee.get().setEmployeeName((employee.getEmployeeName()));
    }
    if (!StringUtils.isEmpty(employee.getEmployeeEmail())) {
      foundEmployee.get().setEmployeeEmail(employee.getEmployeeEmail());
    }
    if (!StringUtils.isEmpty(employee.getEmployeeAddress())) {
      foundEmployee.get().setEmployeeAddress(employee.getEmployeeAddress());
    }
    return employeeRepository.saveAndFlush(foundEmployee.get());
  }

  /**
   * This method is used to delete employee.
   * @param id This is employee id to be deleted.
   */
  @Override
  @Transactional
  public void deleteEmployee(Long id) {
    Optional<Employee> foundEmployee = employeeRepository.findOneById(id);
    if (foundEmployee.isEmpty()) {
      throw  new UsernameNotFoundException("Employee with id " + id + " not found");
    }
    employeeRepository.delete(foundEmployee.get());
  }
}
