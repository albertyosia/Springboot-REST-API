package com.spring.restapi.module.manager;

import com.spring.restapi.RestStatus;
import com.spring.restapi.exceptions.UsernameNotFoundException;
import com.spring.restapi.models.SuccessResponseModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
  private ManagerRepository managerRepository;

  @Override
  public SuccessResponseModel getAllManager() {
    List<Manager> managers = managerRepository.findAll();
    SuccessResponseModel model = new SuccessResponseModel();
    model.setCode(RestStatus.SUCCESS.getCode());
    model.setStatus(RestStatus.SUCCESS.getMessage());
    model.setManagers(managers);
    return model;
  }

  @Override
  @Transactional
  public Manager addManager(Manager manager) {
    return managerRepository.saveAndFlush(manager);
  }

  @Override
  @Transactional
  public Manager updateManager(Long id, Manager manager) {
    Optional<Manager> foundManager = managerRepository.findOneById(id);
    if (foundManager.isEmpty()) {
      throw new UsernameNotFoundException("Manager with id " + id + " not found");
    }
    if (!StringUtils.isEmpty(manager.getFirstName())) {
      foundManager.get().setFirstName((manager.getFirstName()));
    }
    if (!StringUtils.isEmpty(manager.getLastName())) {
      foundManager.get().setLastName(manager.getLastName());
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
    Optional<Manager> foundManager = managerRepository.findOneById(id);
    if (foundManager.isEmpty()) {
      throw new UsernameNotFoundException("Manager with id " + id + " not found");
    }
    managerRepository.delete(foundManager.get());
  }
}
