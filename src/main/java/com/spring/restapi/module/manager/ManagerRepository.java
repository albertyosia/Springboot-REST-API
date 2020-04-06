package com.spring.restapi.module.manager;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
  Optional<Manager> findOneByManagerId(Long id);
}
