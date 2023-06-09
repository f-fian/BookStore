package com.example.BooksStore.service;

import com.example.BooksStore.entity.LibraryUserDetails;
import com.example.BooksStore.exeption.EmailAlreadyExistExeption;
import com.example.BooksStore.exeption.EmailOrPasswordWrongExeption;
import com.example.BooksStore.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("LOAD");
        System.out.println(username);
        return userRepo.findByEmail(username)
                .map(LibraryUserDetails::new)
                .orElseThrow(() -> new EmailOrPasswordWrongExeption("Your email or password is wrong"));
    }
}
