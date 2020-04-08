package com.spring.restapi.module.department;

public interface DepartmentService {
  DepartmentResponseModel getAllDepartment();

  Department addDepartment(Department department);

  Department updateDepartment(Long id, Department department);

  void deleteDepartment(Long id);
}
