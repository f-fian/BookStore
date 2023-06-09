package com.example.BooksStore.entity;

import com.example.BooksStore.dto.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "FirstName cant be blank")
    @Size(min = 3,message = "firstName at least 3 character long")
    private String firstName;

    @NotBlank(message = "LastName cant be blank")
    @Size(min = 3,message = "lastName at least 3 character long")
    private String lastName;

    @NotBlank(message = "Email cant be blank")
    @Size(min = 3,message = "email at least 3 character long")
    private String email;
    @NotBlank(message = "Password cant be blank")
    @Size(min = 3,message = "password at least 3 character long")
    private String password;
    @NotNull
    private Boolean isAdmin;

    public User(String firstName, String lastName, String email, String password, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
