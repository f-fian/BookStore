package com.example.BooksStore.controller;

import com.example.BooksStore.dto.UserBookDto;
import com.example.BooksStore.entity.Book;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



    @PostMapping("user-book/add")
    public void addUserBook(@RequestBody UserBookDto userBook){
        System.out.println("addUserBook");
        this.userService.addUserBook(userBook);
    }

    @GetMapping("user-book/find-all")
    public List<Book> findAllUserBook(@RequestParam(required = false) Long userId)
    {
        return this.userService.findAllBookByUser(userId);

    }

    @DeleteMapping("user-book/delete")
    public void deleteUserBook(@RequestParam(required = true) Long bookId){
        this.userService.deleteUserBook(bookId);

    }

}
















