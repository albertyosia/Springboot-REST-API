package com.spring.restapi.module.department;

import com.spring.restapi.models.GetResponseModel;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DepartmentResponseModel extends GetResponseModel {
  private List<Department> departments;
}
