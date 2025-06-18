package com.security.demo.config;

import com.security.demo.DemoApplication;
import com.security.demo.controller.rolController;
import com.security.demo.controller.userController;
import com.security.demo.repository.Iuser;
import com.security.demo.repository.Irol;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig {

   

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(
            authRequest
            .requestMatchers("api/users/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(withDefaults())
        .build();
    }

}
