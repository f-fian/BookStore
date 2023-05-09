package com.example.BooksStore.controller;


import com.example.BooksStore.entity.Book;
import com.example.BooksStore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;



    @GetMapping("/book/all")
    public List<Book> getAllBooks(){
        return this.booksService.getAllBooks();
    }


    @PostMapping("/book/add")
    public Book addBook(@RequestBody Book book){
        return this.booksService.addBook(book);
    }
}
