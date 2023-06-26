package com.example.BooksStore.service;

import com.example.BooksStore.entity.Book;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepo booksRepo;

    public BooksService(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }


    public List<Book> getAllBooks(){
        return booksRepo.findAll();
    }

    public Book addBook(Book newBook){
        return booksRepo.save(newBook);
    }


    public void deleteBook(Long bookId) {
        booksRepo.deleteById(bookId);
    }
}
