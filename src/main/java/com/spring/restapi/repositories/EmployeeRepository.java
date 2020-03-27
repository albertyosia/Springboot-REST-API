package com.spring.restapi.repositories;

import com.spring.restapi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    Employee findByName(String name);
    Optional<Employee> findOneById(Long id);
    Optional<Employee> deleteById(Optional<Employee> employee);
}
