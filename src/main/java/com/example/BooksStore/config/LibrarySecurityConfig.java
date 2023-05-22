package com.example.BooksStore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class LibrarySecurityConfig {
    private String[] WHITE_LIST = {"/book/all","/user/add"};

//    @Autowired
//    private LibraryUserDetailsService libraryUserDetailsService;
//
//    public LibrarySecurityConfig(LibraryUserDetailsService libraryUserDetailsService){
//        this.libraryUserDetailsService = libraryUserDetailsService;
//    }


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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
