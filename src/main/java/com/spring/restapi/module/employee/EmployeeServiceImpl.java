package com.spring.restapi.module.employee;

import com.spring.restapi.exceptions.AddressLengthException;
import com.spring.restapi.exceptions.DepartmentNotFoundException;
import com.spring.restapi.exceptions.EmailLengthException;
import com.spring.restapi.exceptions.EmailPatternException;
import com.spring.restapi.exceptions.ManagerNotFoundException;
import com.spring.restapi.exceptions.NameLengthException;
import com.spring.restapi.exceptions.RestStatus;
import com.spring.restapi.exceptions.UsernameNotFoundException;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.department.DepartmentRepository;
import com.spring.restapi.module.manager.Manager;
import com.spring.restapi.module.manager.ManagerRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
  private @PersistenceContext EntityManager entityManager;
  private EmployeeRepository employeeRepository;
  private DepartmentRepository departmentRepository;
  private ManagerRepository managerRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ManagerRepository managerRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
    this.managerRepository = managerRepository;
  }

  /**
   * This method is used to return all employee from database.
   * @return list of employee.
   */
  @Override
  public EmployeeResponseModel getAllEmployees() {
    List<Employee> employees = employeeRepository.findAll();
    EmployeeResponseModel model = new EmployeeResponseModel();
    model.setCode(RestStatus.SUCCESS.getCode());
    model.setStatus(RestStatus.SUCCESS.getMessage());
    model.setEmployees(employees);
    return model;
  }

  @Override
  public List<Employee> getEmployees() {
    int maxResult = 5;
    return entityManager.createQuery("SELECT e from Employee e", Employee.class)
      .setMaxResults(maxResult)
      .getResultList();
  }

  @Override
  public List<Employee> getEmployeesOrderByName() {
    int maxResult = 5;
    return entityManager.createQuery("SELECT e from Employee e ORDER BY e.employeeName", Employee.class)
      .setMaxResults(maxResult)
      .getResultList();
  }

  @Override
  public List<Employee> getEmployeesSortByDescending() {
    int maxResult = 5;
    return entityManager.createQuery("SELECT e from Employee e ORDER BY e.employeeName DESC ", Employee.class)
      .setMaxResults(maxResult)
      .getResultList();
  }

  public boolean validateEmail(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
  }

  /**
   * This method is used to add new employee to database.
   * @param newEmployee This is employee from request.
   * @return employee object.
   */
  @Override
  @Transactional
  public Employee addEmployee(Employee newEmployee) {
    final int maxNameLength = 10;
    final int maxEmailLength = 15;
    final int maxAddressLength = 30;

    int nameLength = newEmployee.getEmployeeName().length();
    if (maxNameLength < nameLength) {
      throw new NameLengthException("Name cannot be more than 10 characters");
    }

    boolean result = validateEmail(newEmployee.getEmployeeEmail());
    if (!result) {
      throw new EmailPatternException("Email pattern does not match");
    }

    int emailLength = newEmployee.getEmployeeEmail().length();
    if (maxEmailLength < emailLength) {
      throw new EmailLengthException("Email cannot be more than 15 characters");
    }

    int addressLength = newEmployee.getEmployeeAddress().length();
    if (maxAddressLength < addressLength) {
      throw new AddressLengthException("Address cannot be more than 30 characters");
    }

    Long departmentId = newEmployee.getDepartment().getDepartmentId();
    Optional<Department> foundDepartment = departmentRepository.findByDepartmentId(departmentId);
    if (foundDepartment.isEmpty()) {
      throw new DepartmentNotFoundException("Department not found");
    }

    Long managerId = newEmployee.getManager().getManagerId();
    Optional<Manager> foundManager = managerRepository.findOneByManagerId(managerId);
    if (foundManager.isEmpty()) {
      throw new ManagerNotFoundException("Manager not found");
    }

    newEmployee.setDepartment(foundDepartment.get());
    newEmployee.setManager(foundManager.get());

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
    Optional<Employee> foundEmployee = employeeRepository.findOneByEmployeeId(id);
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
    Optional<Employee> foundEmployee = employeeRepository.findOneByEmployeeId(id);
    if (foundEmployee.isEmpty()) {
      throw  new UsernameNotFoundException("Employee with id " + id + " not found");
    }
    employeeRepository.delete(foundEmployee.get());
  }
}
