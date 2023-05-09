package com.example.BooksStore.repo;

import com.example.BooksStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Book,Long> {
}
