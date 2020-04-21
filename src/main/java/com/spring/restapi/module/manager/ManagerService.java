package com.spring.restapi.module.manager;


public interface ManagerService {
  ManagerResponseModel getAllManager();

  Manager getGeneratedManager(Manager manager);

  Manager getUpdatedManager(Long id, Manager manager);

  void deleteManager(Long id);
}
