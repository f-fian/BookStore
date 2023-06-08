package com.example.BooksStore.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistExeption extends RuntimeException{
    public EmailAlreadyExistExeption(String message) {
        super(message);
    }
}
