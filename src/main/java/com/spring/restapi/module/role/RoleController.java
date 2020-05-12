package com.spring.restapi.module.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

  @Autowired RoleService roleService;

  @PostMapping("/")
  public Role getGeneratedRole(@RequestBody Role role) {
    return roleService.getGeneratedRole(role);
  }

  @DeleteMapping("/{id}")
  public void deleteRole(@PathVariable("id") Long id) {
    roleService.deleteRole(id);
  }
}
