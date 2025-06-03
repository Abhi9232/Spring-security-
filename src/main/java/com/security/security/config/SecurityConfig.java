package com.security.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
          http.authorizeHttpRequests(request -> request
                  .requestMatchers("/api/auth/**").permitAll()
                  .anyRequest().authenticated());

          http.csrf(csrf -> csrf.disable());
          http.csrf(AbstractHttpConfigurer::disable);
          http.authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthFilter,
                  UsernamePasswordAuthenticationFilter.class);


          return http.build();
     }

     @Bean
     private AuthenticationProvider authenticationProvider() {
          DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
return  daoAuthenticationProvider;
     }


}

