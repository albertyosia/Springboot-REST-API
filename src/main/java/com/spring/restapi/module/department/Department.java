package com.spring.restapi.module.department;

import com.spring.restapi.module.employee.Employee;
import com.spring.restapi.module.manager.Manager;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "department")
public class Department {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long departmentId;
  private @Column (name = "department_name") String departmentName;
  private @OneToOne(mappedBy = "department") Employee employee;
  private @OneToOne(mappedBy = "department") Manager manager;
}
