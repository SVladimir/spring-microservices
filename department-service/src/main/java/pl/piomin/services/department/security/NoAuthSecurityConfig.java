package pl.piomin.services.department.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Profile({"no-security", "test"})
public class NoAuthSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        .cors()
        .and()
        .csrf().disable()
        .authorizeRequests()
        .anyRequest()
        .permitAll()
        .and()
        .build();
  }

}
