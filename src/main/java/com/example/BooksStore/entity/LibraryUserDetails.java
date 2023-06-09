package com.example.BooksStore.entity;

import com.example.BooksStore.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryUserDetails implements UserDetails {

    private String firstName;

    private String lastName;

    private String email;
    private String password;
    private Boolean authorities;

    public LibraryUserDetails(User user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        password = user.getPassword();
        authorities = user.getIsAdmin();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.authorities){
            return Arrays.stream(new String[]{"ADMIN"}).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }else{
            return Arrays.stream(new String[]{"USER"}).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
