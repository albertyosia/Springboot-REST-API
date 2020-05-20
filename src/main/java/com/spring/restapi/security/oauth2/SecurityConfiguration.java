package com.spring.restapi.security.oauth2;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired DataSource dataSource;
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//      .antMatcher("/**")
//      .authorizeRequests()
//      .antMatchers("/oauth/authorize**", "/login**", "/error**")
//      .permitAll()
//      .and()
//      .authorizeRequests()
//      .anyRequest().authenticated()
//      .and()
//      .formLogin().permitAll();
//  }

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//        .jdbcAuthentication()
//        .dataSource(dataSource)
//        .usersByUsernameQuery(
//          "select username,password,enabled from users where username = ?")
//        .authoritiesByUsernameQuery(
//          "select username,authority from roles where username = ?");
//  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
