package com.spring.restapi.module.department;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  Optional<Department> findOneById(Long id);
}
