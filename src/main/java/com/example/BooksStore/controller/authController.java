package com.example.BooksStore.controller;

import com.example.BooksStore.dto.AuthenticationResponse;
import com.example.BooksStore.dto.LoginUserDto;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.repo.UserRepo;
import com.example.BooksStore.service.AuthService;
import com.example.BooksStore.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class authController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody LoginUserDto loginUserDto)
    {
        System.out.println("sini");
        return authService.authentication(loginUserDto);
//        return jwtService.generateToken(user);

    }

    @PostMapping("register")
    public AuthenticationResponse addUser(@Valid @RequestBody User user){
        return this.authService.addUser(user);
    }
}
