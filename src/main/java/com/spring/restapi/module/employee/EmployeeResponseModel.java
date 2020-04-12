package com.spring.restapi.module.employee;

import com.spring.restapi.models.GetResponseModel;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponseModel extends GetResponseModel {
  private List<Employee> employees;
}
