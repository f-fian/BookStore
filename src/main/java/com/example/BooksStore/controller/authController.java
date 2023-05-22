package com.example.BooksStore.controller;

import com.example.BooksStore.dto.LoginUserDto;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.repo.UserRepo;
import com.example.BooksStore.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class authController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public String authenticate(
            @RequestBody LoginUserDto loginUserDto
    )
    {
        System.out.println("authenticate");

         Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserDto.username(),
                        loginUserDto.password()
                )
         );
        if(authentication.isAuthenticated()) {
            System.out.println("authenticated mas bro!!");
        }

        var user = userRepo.findByUsername(loginUserDto.username()).orElseThrow();

        return jwtService.generateToken(user);
    }
}
