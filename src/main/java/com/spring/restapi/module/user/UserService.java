package com.spring.restapi.module.user;

import java.util.List;

public interface UserService {
  List<User> getAllUser();

  User getGeneratedUser(User user);

  User getUpdatedUser(Long id, User user);

  void deleteUser(Long id);
}
