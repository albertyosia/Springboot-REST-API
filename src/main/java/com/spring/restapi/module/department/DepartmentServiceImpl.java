package com.spring.restapi.module.department;

import com.spring.restapi.exceptions.DepartmentNotFoundException;
import com.spring.restapi.exceptions.RestStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
  private DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public DepartmentResponseModel getAllDepartment() {
    List<Department> departments = departmentRepository.findAll();
    DepartmentResponseModel model = new DepartmentResponseModel();
    model.setCode(RestStatus.SUCCESS.getCode());
    model.setStatus(RestStatus.SUCCESS.getMessage());
    model.setDepartments(departments);
    return model;
  }

  @Override
  @Transactional
  public Department getGeneratedDepartment(Department department) {
    return departmentRepository.saveAndFlush(department);
  }

  @Override
  @Transactional
  public Department getUpdatedDepartment(Long id, Department department) {
    Optional<Department> foundDepartment = departmentRepository.findByDepartmentId(id);
    if (foundDepartment.isEmpty()) {
      throw new DepartmentNotFoundException("Department with id " + id + " not found");
    }
    if (!StringUtils.isEmpty(department.getDepartmentName())) {
      foundDepartment.get().setDepartmentName(department.getDepartmentName());
    }
    return departmentRepository.saveAndFlush(foundDepartment.get());
  }

  @Override
  @Transactional
  public void deleteDepartment(Long id) {
    Optional<Department> foundDepartment = departmentRepository.findByDepartmentId(id);
    if (foundDepartment.isEmpty()) {
      throw new DepartmentNotFoundException("Department with id " + id + " not found");
    }
    departmentRepository.delete(foundDepartment.get());
  }
}
