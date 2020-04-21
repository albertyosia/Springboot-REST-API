package com.spring.restapi.module.manager;

import com.spring.restapi.models.GetResponseModel;
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
@RequestMapping("/manager")
public class ManagerController {
  @Autowired ManagerService managerService;

  @GetMapping("/")
  public GetResponseModel getAllManager() {
    return managerService.getAllManager();
  }

  @PostMapping("/")
  public Manager getGeneratedManager(@RequestBody Manager manager) {
    return managerService.getGeneratedManager(manager);
  }

  @PutMapping("/{id}")
  public Manager getUpdatedManager(@PathVariable("id") Long id, @RequestBody Manager manager) {
    return managerService.getUpdatedManager(id, manager);
  }

  @DeleteMapping("/{id}")
  public void deleteManager(@PathVariable("id") Long id) {
    managerService.deleteManager(id);
  }
}
