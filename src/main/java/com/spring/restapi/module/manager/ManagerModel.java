package com.spring.restapi.module.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.employee.Employee;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ManagerModel extends Manager {
  private @JsonIgnore Department department;
  private @JsonIgnore List<Employee> employees;
}
