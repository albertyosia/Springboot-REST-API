package com.spring.restapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "employee")
public class Employee {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private @Column(name = "employee_name") String name;
  private @Column(name = "employee_email") String email;
  private @Column(name = "employee_address") String address;

  /**
   * This is constructor.
   * @param id This is employee id
   * @param name This is employee name.
   * @param email This is employee email.
   * @param address This is employee address.
   */
  public Employee(Long id, String name, String email, String address) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
  }
}



