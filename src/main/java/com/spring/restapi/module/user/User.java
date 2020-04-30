package com.spring.restapi.module.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private @Column(name = "username")  String username;
  private @Column(name = "password")  String password;
  private @Column(name = "enabled") boolean enabled;
  private @Column(name = "role") String role;
}
