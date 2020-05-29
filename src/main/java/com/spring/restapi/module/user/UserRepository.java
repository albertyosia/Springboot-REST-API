package com.spring.restapi.module.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
    JpaRepository<User, Long>,
    PagingAndSortingRepository<User, Long> {
  User findByUsername(String username);
}
