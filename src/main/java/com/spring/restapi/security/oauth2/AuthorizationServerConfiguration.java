package com.spring.restapi.security.oauth2;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

  @Autowired BCryptPasswordEncoder passwordEncoder;

  @Autowired DataSource dataSource;

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints)
    throws Exception {
    endpoints
      .tokenStore(new JdbcTokenStore(dataSource));
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()")
        .allowFormAuthenticationForClients();
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
      .jdbc(dataSource);
    //      .inMemory()
    //      .withClient("clientapp").secret(passwordEncoder.encode("123456"))
    //      .authorizedGrantTypes("password", "authorization_code", "refresh_token")
    //      .authorities("READ_ONLY_CLIENT")
    //      .scopes("read_profile_info")
    //      .resourceIds("oauth2-resource")
    //      .redirectUris("http://localhost:8081/login")
    //      .accessTokenValiditySeconds(120)
    //      .refreshTokenValiditySeconds(240000);
  }

  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setSupportRefreshToken(true);
    tokenServices.setAccessTokenValiditySeconds(300);
    tokenServices.setRefreshTokenValiditySeconds(6000);
    tokenServices.setTokenStore(new JdbcTokenStore(dataSource));
    return tokenServices;
  }

}
