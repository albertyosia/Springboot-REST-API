package com.spring.restapi.security.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity security) throws Exception {
    security
        .authorizeRequests()
        .antMatchers("/users/").hasRole("ADMIN")
        .antMatchers("/departments/").hasRole("USER");
  }
}
