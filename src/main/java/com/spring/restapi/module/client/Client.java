package com.spring.restapi.module.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "oauth2_client_details")
public class Client {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private @Column(name = "client_id") String clientId;
  private @Column(name = "client_secret") String clientSecret;
  private @Column(name = "scope") String scope;
  private @Column(name = "authorities") String authorities;
  private @Column(name = "authorized_grant_types") String authorizedGrantTypes;
  private @Column(name = "access_token_validity") int accessTokenValidity;
  private @Column(name = "refresh_token_validity") int refreshTokenValidity;
}
