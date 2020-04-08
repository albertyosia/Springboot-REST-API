package com.spring.restapi.module.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.manager.Manager;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeModel extends Employee {
  private @JsonIgnore Department department;
  private @JsonIgnore Manager manager;
}
