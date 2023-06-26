package com.example.BooksStore.controller;


import com.example.BooksStore.entity.Book;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        this.booksService.deleteBook(bookId);
    };





}












