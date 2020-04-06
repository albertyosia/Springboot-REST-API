package com.spring.restapi.module.manager;


public interface ManagerService {
  ManagerResponseModel getAllManager();

  Manager addManager(Manager manager);

  Manager updateManager(Long id, Manager manager);

  void deleteManager(Long id);
}
