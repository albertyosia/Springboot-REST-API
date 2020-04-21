package com.spring.restapi.module.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired private EmployeeService employeeService;

  /**
   * This method is used to return all employee from database.
   * @return list of employee
   */
  @GetMapping("/")
  public EmployeeResponseModel getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  /**
   * This method is used to return page with employee detail.
   * @param page offset.
   * @param size limit.
   * @return page with employee detail.
   */
  @GetMapping("/pageable")
  public Page<Employee> getPageableEmployee(
      @RequestParam("page") int page,
      @RequestParam("size") int size) {
    return employeeService.getPageableEmployee(page,size);
  }

  /**
   * This method is used to return only five employees.
   * @return list of five employee
   */
  @GetMapping("/limit/5")
  public List<Employee> getFiveEmployees() {
    return employeeService.getFiveEmployee();
  }

  /**
   * This method is used to return five employees ordered by employee name.
   * @return list of five employee
   */
  @GetMapping("/sort/name")
  public List<Employee> getEmployeesOrderByName() {
    return employeeService.getFiveEmployeeOrderByName();
  }

  /**
   * This method is used to return five employee sorted descending.
   * @return list of five employee sorted descending.
   */
  @GetMapping("/sort/desc")
  public List<Employee> getEmployeesDescending() {
    return employeeService.getFiveEmployeeSortByDescending();
  }

  /**
   * This method is used to add new employee to database.
   * @param employee This is employee from request.
   * @return employee object.
   */
  @PostMapping("/")
  public Employee getGeneratedEmployee(@RequestBody Employee employee) {
    return employeeService.getGeneratedEmployee(employee);
  }

  /**
   * This method is used to update current employee.
   * @param id This is employee id to be updated.
   * @param employee This is employee from request.
   * @return return updated current employee object.
   */
  @PutMapping("/{id}")
  public Employee getUpdatedEmployee(@PathVariable("id") Long id,
                                 @RequestBody Employee employee) {
    return employeeService.getUpdatedEmployee(id, employee);
  }

  /**
   * This method is used to delete employee.
   * @param id This is employee id to be deleted.
   */
  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable("id") Long id) {
    employeeService.deleteEmployee(id);
  }
}
