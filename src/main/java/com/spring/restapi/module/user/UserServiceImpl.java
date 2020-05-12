package com.spring.restapi.module.user;

import com.spring.restapi.exceptions.RoleNotFoundException;
import com.spring.restapi.exceptions.UsernameNotFoundException;
import com.spring.restapi.module.role.Role;
import com.spring.restapi.module.role.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  @Override
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public User getGeneratedUser(User user) {
    Optional<Role> foundRole = roleRepository.findOneById(user.getRole().getId());
    if (foundRole.isEmpty()) {
      throw new RoleNotFoundException("Role with id " + user.getRole().getId() + " NOT FOUND");
    }
    user.setRole(foundRole.get());
    user.setPassword(encoder.encode(user.getPassword()));
    user.setEnabled(true);
    return userRepository.saveAndFlush(user);
  }

  @Override
  @Transactional
  public User getUpdatedUser(Long id, User user) {
    Optional<User> foundUser = userRepository.findById(id);
    if (foundUser.isEmpty()) {
      throw new UsernameNotFoundException("User with id " + id + "not found");
    }
    foundUser.get().setUsername(user.getUsername());
    foundUser.get().setPassword(encoder.encode(user.getPassword()));
    return userRepository.saveAndFlush(foundUser.get());
  }

  @Override
  @Transactional
  public void deleteUser(Long id) {
    Optional<User> foundUser = userRepository.findById(id);
    if (foundUser.isEmpty()) {
      throw new UsernameNotFoundException("User with id " + id + "not found");
    }
    userRepository.delete(foundUser.get());
  }
}
