package com.spring.restapi.security.oauth2;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/departments/").hasRole("ADMIN")
      .antMatchers("/users/").hasRole("USER")
      .antMatchers("/managers/").hasRole("USER")
      .anyRequest()
      .authenticated()
      .and().formLogin();
  }
}
