package com.spring.restapi.module.role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>,
    PagingAndSortingRepository<Role, Long> {
  Optional<Role> findOneById(Long id);
}
