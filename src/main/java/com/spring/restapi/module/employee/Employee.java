package com.spring.restapi.module.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.restapi.module.department.Department;
import com.spring.restapi.module.department.DepartmentModel;
import com.spring.restapi.module.manager.Manager;
import com.spring.restapi.module.manager.ManagerModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

  @ManyToOne
  @JoinTable(name = "manager_employees",
      joinColumns = @JoinColumn(name = "employee_id"),
      inverseJoinColumns = @JoinColumn(name = "manager_id"))
   private Manager manager;

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

  /**
   * This method is used to get Department model.
   * @return department model.
   */
  public Department getDepartmentModel() {
    if (department != null) {
      DepartmentModel model = new DepartmentModel();
      model.setDepartmentName(department.getDepartmentName());
      model.setDepartmentId(department.getDepartmentId());
      return model;
    }
    return null;
  }

  /**
   * This method is used to get Manager model.
   * @return manager model.
   */
  public Manager getManagerModel() {
    if (manager != null) {
      ManagerModel model = new ManagerModel();
      model.setManagerId(manager.getManagerId());
      model.setManagerFirstName(manager.getManagerFirstName());
      model.setManagerLastName(manager.getManagerLastName());
      model.setBranchName(manager.getBranchName());
      model.setPromotionDate(manager.getPromotionDate());
      return model;
    }
    return null;
  }
}



