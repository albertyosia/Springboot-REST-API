package com.spring.restapi.module.manager;

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
@RequestMapping("/manager")
public class ManagerController {
  @Autowired ManagerService managerService;

  @GetMapping("/")
  public SuccessResponseModel getAllManager() {
    return managerService.getAllManager();
  }

  @PostMapping("/")
  public Manager addNewManager(@RequestBody Manager manager) {
    return managerService.addManager(manager);
  }

  @PutMapping("/{id}")
  public Manager updateManager(@PathVariable("id") Long id, @RequestBody Manager manager) {
    return managerService.updateManager(id, manager);
  }

  @DeleteMapping("/{id}")
  public void deleteManager(@PathVariable("id") Long id) {
    managerService.deleteManager(id);
  }
}
