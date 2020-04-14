package com.spring.restapi.module.employee;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
  Optional<Employee> findOneByEmployeeId(Long id);

  List<Employee> findTop5By();

  List<Employee> findTop5ByOrderByEmployeeName();

  List<Employee> findTop5ByOrderByEmployeeNameDesc();

  Page<Employee> findTop3ByOrderByEmployeeNameDesc(Pageable pageable);
}
