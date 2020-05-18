package com.spring.restapi.module.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.manager.Manager;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "employee")
public class Employee {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long employeeId;
  private @Column(name = "employee_name") String employeeName;
  private @Column(name = "employee_email") String employeeEmail;
  private @Column(name = "employee_address") String employeeAddress;
  private @OneToOne @JoinColumn(name = "department_id") Department department;
  private @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "fk_manager") @JsonManagedReference Manager manager;

  /**
   * This is constructor.
   * @param employeeId This is employee id.
   * @param employeeName This is employee name.
   * @param employeeEmail This is employee email.
   * @param employeeAddress This is employee address.
   */
  public Employee(
      Long employeeId,
      String employeeName,
      String employeeEmail,
      String employeeAddress) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.employeeEmail = employeeEmail;
    this.employeeAddress = employeeAddress;
  }

}



