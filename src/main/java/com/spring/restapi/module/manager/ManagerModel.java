package com.spring.restapi.module.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.employee.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ManagerModel extends Manager {
  private @JsonIgnore Department department;
  private @JsonIgnore List<Employee> employees;
}
