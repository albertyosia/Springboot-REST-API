package com.spring.restapi.module.employee;

import com.spring.restapi.exceptions.AddressLengthException;
import com.spring.restapi.exceptions.AttributeContainScriptException;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;
  private DepartmentRepository departmentRepository;
  private ManagerRepository managerRepository;

  /**
   * Constructor.
   * @param employeeRepository for access employee data.
   * @param departmentRepository for access department data.
   * @param managerRepository for access manager data.
   */
  public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ManagerRepository managerRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
    this.managerRepository = managerRepository;
  }

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
  public Page<Employee> getPageableEmployee(Integer page, Integer size) {
    Pageable showData = PageRequest.of(page, size, Sort.by("employeeName").descending());
    return employeeRepository.findTop3ByOrderByEmployeeNameDesc(showData);
  }

  @Override
  public List<Employee> getFiveEmployee() {
    return employeeRepository.findTop5By();
  }

  @Override
  public List<Employee> getFiveEmployeeOrderByName() {
    return employeeRepository.findTop5ByOrderByEmployeeName();
  }

  @Override
  public List<Employee> getFiveEmployeeSortByDescending() {
    return employeeRepository.findTop5ByOrderByEmployeeNameDesc();
  }

  public boolean validateEmail(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
  }

  public boolean validateScript(String str) {
    String regex = "[<script>]*(\\w)*[</script>]|[<html>]*(\\w)*[</html>]";
    return str.matches(regex);
  }

  /**
   * This method is used to validate attribute of Employee.
   * @param employee Employee object.
   * @return true.
   */
  public boolean validateAttribute(Employee employee) {
    final int maxNameLength = 10;
    final int maxEmailLength = 15;
    final int maxAddressLength = 30;
    int nameLength = employee.getEmployeeName().length();
    if (maxNameLength < nameLength) {
      throw new NameLengthException("Name cannot be more than 10 characters");
    }

    boolean validateName = validateScript(employee.getEmployeeName());
    if (!validateName) {
      throw new AttributeContainScriptException("Name must not contain script");
    }

    boolean validateEmail = validateScript(employee.getEmployeeEmail());
    if (!validateEmail) {
      throw new AttributeContainScriptException("Email must not contain script");
    }

    boolean validateAddress = validateScript(employee.getEmployeeAddress());
    if (!validateAddress) {
      throw new AttributeContainScriptException("Address must not contain script");
    }

    boolean resultEmailValidate = validateEmail(employee.getEmployeeEmail());
    if (!resultEmailValidate) {
      throw new EmailPatternException("Email pattern does not match");
    }

    int emailLength = employee.getEmployeeEmail().length();
    if (maxEmailLength < emailLength) {
      throw new EmailLengthException("Email cannot be more than 15 characters");
    }

    int addressLength = employee.getEmployeeAddress().length();
    if (maxAddressLength < addressLength) {
      throw new AddressLengthException("Address cannot be more than 30 characters");
    }
    return true;
  }

  @Override
  @Transactional
  public Employee addEmployee(Employee newEmployee) {

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

    boolean resultValidateAttribute = validateAttribute(newEmployee);
    if (resultValidateAttribute) {
      newEmployee.setDepartment(foundDepartment.get());
      newEmployee.setManager(foundManager.get());
    }

    return employeeRepository.saveAndFlush(newEmployee);
  }


  @Override
  @Transactional
  public Employee updateEmployee(Long id, Employee employee) {

    Optional<Employee> foundEmployee = employeeRepository.findOneByEmployeeId(id);
    if (foundEmployee.isEmpty()) {
      throw new UsernameNotFoundException("Employee with id " + id + " not found");
    }

    boolean result = validateAttribute(employee);

    if (result) {
      if (!StringUtils.isEmpty(employee.getEmployeeName())) {
        foundEmployee.get().setEmployeeName((employee.getEmployeeName()));
      }
      if (!StringUtils.isEmpty(employee.getEmployeeEmail())) {
        foundEmployee.get().setEmployeeEmail(employee.getEmployeeEmail());
      }
      if (!StringUtils.isEmpty(employee.getEmployeeAddress())) {
        foundEmployee.get().setEmployeeAddress(employee.getEmployeeAddress());
      }
    }

    return employeeRepository.saveAndFlush(foundEmployee.get());
  }

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
