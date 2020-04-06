package com.spring.restapi.module.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
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
   * This method is used to add new employee to database.
   * @param employee This is employee from request.
   * @return employee object.
   */
  @PostMapping("/")
  public Employee addNewEmployee(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  /**
   * This method is used to update current employee.
   * @param id This is employee id to be updated.
   * @param employee This is employee from request.
   * @return return updated current employee object.
   */
  @PutMapping("/{id}")
  public Employee updateEmployee(@PathVariable("id") Long id,
                                 @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
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
