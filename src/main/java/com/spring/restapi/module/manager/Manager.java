package com.spring.restapi.module.manager;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.employee.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "manager")
public class Manager {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long managerId;
  private @Column(name = "branch_name") String branchName;
  private @Column(name = "first_name") String managerFirstName;
  private @Column(name = "last_name") String managerLastName;
  private @Column(name = "promotion_date") Date promotionDate;
  private @OneToOne @JoinColumn(name = "department_id") Department department;

  @OneToMany(mappedBy = "manager")
  @JsonManagedReference
  private List<Employee> employees = new ArrayList<>();
}
