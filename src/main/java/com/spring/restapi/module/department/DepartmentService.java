package com.spring.restapi.module.department;

public interface DepartmentService {
  DepartmentResponseModel getAllDepartment();

  Department getGeneratedDepartment(Department department);

  Department getUpdatedDepartment(Long id, Department department);

  void deleteDepartment(Long id);
}
