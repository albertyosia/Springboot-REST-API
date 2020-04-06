package com.spring.restapi.module.department;

import com.spring.restapi.models.SuccessResponseModel;

public interface DepartmentService {
  DepartmentResponseModel getAllDepartment();

  Department addDepartment(Department department);

  Department updateDepartment(Long id, Department department);

  void deleteDepartment(Long id);
}
