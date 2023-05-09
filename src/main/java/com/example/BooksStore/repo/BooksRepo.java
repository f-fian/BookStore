package com.example.BooksStore.repo;

import com.example.BooksStore.entity.Book;
import com.example.BooksStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepo extends JpaRepository<Book,Long> {

//    public Book findBookByUser(User user);

    public List<Book> findAllBookByUser(User user);
}
