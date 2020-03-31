package com.spring.restapi.repositories;

import com.spring.restapi.entities.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Employee findByName(String name);

  Optional<Employee> findOneById(Long id);
}
