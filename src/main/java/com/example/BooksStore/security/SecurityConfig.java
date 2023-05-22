package com.example.BooksStore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private String[] WHITE_LIST = {"/book/all"};
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .build();
    }
}
