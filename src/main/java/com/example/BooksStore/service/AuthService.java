package com.example.BooksStore.service;

import com.example.BooksStore.dto.AuthenticationResponse;
import com.example.BooksStore.dto.LoginUserDto;
import com.example.BooksStore.entity.Token;
import com.example.BooksStore.entity.TokenType;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.exeption.EmailAlreadyExistExeption;
import com.example.BooksStore.exeption.EmailOrPasswordWrongExeption;
import com.example.BooksStore.repo.TokenRepo;
import com.example.BooksStore.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final TokenRepo tokenRepo;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse addUser(User user) {


        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try{
            userRepo.save(user);
        }catch (DataAccessException exception){
            throw new EmailAlreadyExistExeption("Your email already in use");
        }

        String jwt = jwtService.generateToken(user);
        Token token = new Token(jwt, TokenType.BEARER,false,false,user);
        tokenRepo.save(token);
        return new AuthenticationResponse(jwt);
    }

    public AuthenticationResponse authentication(LoginUserDto loginUserDto) {
        System.out.println("sini2");
        System.out.println(loginUserDto.email());
        System.out.println(loginUserDto.password());
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserDto.email(),
                        loginUserDto.password()
                )
        );
        System.out.println("sini3");
        if(!(authentication.isAuthenticated())) {
            System.out.println("sini4");
            throw new EmailAlreadyExistExeption("please check your email or password");

        }
        System.out.println("sini5");
        User user = userRepo.findByEmail(loginUserDto.email()).orElseThrow();

        String jwt = jwtService.generateToken(user);
        Token token = new Token(jwt, TokenType.BEARER,false,false,user);
        tokenRepo.save(token);
        return new AuthenticationResponse(jwt);
    }
}
