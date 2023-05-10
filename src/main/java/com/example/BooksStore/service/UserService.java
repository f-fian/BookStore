package com.example.BooksStore.service;

import com.example.BooksStore.dto.UserBookDto;
import com.example.BooksStore.entity.Book;
import com.example.BooksStore.entity.User;
import com.example.BooksStore.repo.BooksRepo;
import com.example.BooksStore.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BooksRepo booksRepo;


    public User addUser(User newUser){
        return userRepo.save(newUser);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }


    public void addUserBook(UserBookDto userBook){
        Optional<User> optionalUser = userRepo.findById(userBook.userId().longValue());
        Optional<Book> optionalBook = booksRepo.findById(userBook.bookId().longValue());
        User user = optionalUser.get();
        Book book = optionalBook.get();
        book.setUser(user);
        booksRepo.save(book);
//        return booksRepo.findAllBookByUser(user);
    }

    public List<Book> findAllBookByUser(Long userId){
        User user = userRepo.findById(userId).get();
        List<Book> booksByUser = booksRepo.findAllBookByUser(user);
        return booksByUser;
    }


    public void deleteUserBook(Long bookId){
        Book book = booksRepo.findById(bookId).get();
        book.setUser(null);
        booksRepo.save(book);
    }
}
















