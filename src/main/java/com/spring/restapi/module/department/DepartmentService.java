package com.spring.restapi.module.department;

import com.spring.restapi.models.SuccessResponseModel;

public interface DepartmentService {
  SuccessResponseModel getAllDepartment();

  Department addDepartment(Department department);

  Department updateDepartment(Long id, Department department);

  void deleteDepartment(Long id);
}
