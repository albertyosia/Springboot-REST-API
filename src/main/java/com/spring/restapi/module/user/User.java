package com.spring.restapi.module.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.restapi.module.role.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private @Column(name = "username") String username;
  private @Column(name = "password") String password;
  private @Column(name = "enabled") boolean enabled;
  private @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "fk_role") @JsonBackReference Role role;
}
