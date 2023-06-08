package com.example.BooksStore.config;


import com.example.BooksStore.entity.User;
import com.example.BooksStore.exeption.EmailOrPasswordWrongExeption;
import com.example.BooksStore.repo.UserRepo;
import com.example.BooksStore.service.LibraryUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final LibraryUserDetailsService userDetailsServiceImp;

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("masuk sini ngak");
        System.out.println(authentication);

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails user = userDetailsServiceImp.loadUserByUsername(email);
        System.out.println("DDDDDD");
        System.out.println(user.getPassword());
        if(!(passwordEncoder.matches(password,user.getPassword()))){
            throw new EmailOrPasswordWrongExeption("Your email or password is wrong");
        }


        System.out.println("Principal");
        System.out.println(email);
        System.out.println(password);
        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(email,password,user.getAuthorities());
        System.out.println(userToken);

        return userToken;
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.equals(authenticationType);
    }
}




