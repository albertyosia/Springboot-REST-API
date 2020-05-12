package com.spring.restapi.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private DataSource dataSource;

  public SecurityConfiguration(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
          "select username,password,enabled from users where username = ?")
        .authoritiesByUsernameQuery(
          "select username,authority from roles where username = ?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/roles/").hasRole("ADMIN")
      .antMatchers("/departments/").hasRole("ADMIN")
      .antMatchers("/users/").hasRole("USER")
      .antMatchers("/managers/").hasRole("USER")
      .anyRequest()
      .authenticated()
      .and().formLogin();
  }
}
