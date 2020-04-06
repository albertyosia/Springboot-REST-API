package com.spring.restapi.module.department;

import com.spring.restapi.models.SuccessResponseModel;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DepartmentResponseModel extends SuccessResponseModel {
  private List<Department> departments;
}
