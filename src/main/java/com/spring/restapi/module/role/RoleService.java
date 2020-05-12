package com.spring.restapi.module.role;

public interface RoleService {
  Role getGeneratedRole(Role role);

  void deleteRole(Long id);
}
