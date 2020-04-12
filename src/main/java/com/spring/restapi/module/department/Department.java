package com.spring.restapi.module.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.restapi.module.employee.Employee;
import com.spring.restapi.module.manager.Manager;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"employee", "manager"})
@Table(name = "department")
public class Department {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long departmentId;
  private @Column (name = "department_name") String departmentName;
  private @OneToOne Employee employee;
  private @OneToOne Manager manager;
}
