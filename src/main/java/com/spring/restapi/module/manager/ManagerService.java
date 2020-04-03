package com.spring.restapi.module.manager;

import com.spring.restapi.models.SuccessResponseModel;

public interface ManagerService {
  SuccessResponseModel getAllManager();

  Manager addManager(Manager manager);

  Manager updateManager(Long id, Manager manager);

  void deleteManager(Long id);
}
