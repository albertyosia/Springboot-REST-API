package com.spring.restapi.module.department;

import com.spring.restapi.models.SuccessResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
  @Autowired DepartmentService departmentService;

  @GetMapping("/")
  public SuccessResponseModel getAllDepartment() {
    return departmentService.getAllDepartment();
  }

  @PostMapping("/")
  public Department addNewDepartment(@RequestBody Department department) {
    return departmentService.addDepartment(department);
  }

  @PutMapping("/{id}")
  public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
    return departmentService.updateDepartment(id, department);
  }

  @DeleteMapping("/{id}")
  public void deleteDepartment(@PathVariable("id") Long id) {
    departmentService.deleteDepartment(id);
  }
}
