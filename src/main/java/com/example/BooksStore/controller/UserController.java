package com.example.BooksStore.controller;

import com.example.BooksStore.dto.UserBookDto;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("user/all")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    @PostMapping("user/add")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }



    @PostMapping("user-book")
    public void addUserBook(@RequestBody UserBookDto userBook){
        this.userService.addUserBook(userBook);
    }
}
















