package com.spring.restapi.module.department;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.restapi.module.employee.Employee;
import com.spring.restapi.module.manager.Manager;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentModel extends Department {
   private @JsonIgnore Employee employee;
   private @JsonIgnore Manager manager;
}
