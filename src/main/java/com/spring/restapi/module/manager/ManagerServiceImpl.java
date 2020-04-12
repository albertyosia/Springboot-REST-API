package com.spring.restapi.module.manager;

import com.spring.restapi.exceptions.ManagerNotFoundException;
import com.spring.restapi.exceptions.RestStatus;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.department.DepartmentRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
  private ManagerRepository managerRepository;
  private DepartmentRepository departmentRepository;

  public ManagerServiceImpl(ManagerRepository managerRepository, DepartmentRepository departmentRepository) {
    this.managerRepository = managerRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public ManagerResponseModel getAllManager() {
    List<Manager> managers = managerRepository.findAll();
    ManagerResponseModel model = new ManagerResponseModel();
    model.setCode(RestStatus.SUCCESS.getCode());
    model.setStatus(RestStatus.SUCCESS.getMessage());
    model.setManagers(managers);
    return model;
  }

  @Override
  @Transactional
  public Manager addManager(Manager manager) {
    Optional<Department> foundDepartment = departmentRepository.findByDepartmentId(manager.getDepartment().getDepartmentId());
    if (foundDepartment.isEmpty()) {
      throw new ManagerNotFoundException("Department not Found");
    }
    manager.setPromotionDate(new Date());
    manager.setDepartment(foundDepartment.get());
    return managerRepository.saveAndFlush(manager);
  }

  @Override
  @Transactional
  public Manager updateManager(Long id, Manager manager) {
    Optional<Manager> foundManager = managerRepository.findOneByManagerId(id);
    if (foundManager.isEmpty()) {
      throw new ManagerNotFoundException("Manager with id " + id + " not found");
    }
    if (!StringUtils.isEmpty(manager.getManagerFirstName())) {
      foundManager.get().setManagerFirstName((manager.getManagerFirstName()));
    }
    if (!StringUtils.isEmpty(manager.getManagerFirstName())) {
      foundManager.get().setManagerFirstName(manager.getManagerFirstName());
    }
    if (!StringUtils.isEmpty(manager.getBranchName())) {
      foundManager.get().setBranchName(manager.getBranchName());
    }
    if (!StringUtils.isEmpty(manager.getPromotionDate())) {
      foundManager.get().setPromotionDate(manager.getPromotionDate());
    }
    return managerRepository.saveAndFlush(foundManager.get());
  }

  @Override
  @Transactional
  public void deleteManager(Long id) {
    Optional<Manager> foundManager = managerRepository.findOneByManagerId(id);
    if (foundManager.isEmpty()) {
      throw new ManagerNotFoundException("Manager with id " + id + " not found");
    }
    managerRepository.delete(foundManager.get());
  }
}
