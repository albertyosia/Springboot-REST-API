package com.spring.restapi.module.role;

import com.spring.restapi.exceptions.RoleNotFoundException;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  @Transactional
  public Role getGeneratedRole(Role role) {
    return roleRepository.saveAndFlush(role);
  }

  @Override
  @Transactional
  public void deleteRole(Long id) {
    Optional<Role> foundRole = roleRepository.findOneById(id);
    if (foundRole.isEmpty()) {
      throw new RoleNotFoundException("Role with id " + id + " not found");
    }
    roleRepository.delete(foundRole.get());
  }
}
