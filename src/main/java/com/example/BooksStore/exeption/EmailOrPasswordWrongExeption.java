package com.example.BooksStore.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class EmailOrPasswordWrongExeption extends RuntimeException{
    public EmailOrPasswordWrongExeption(String message) {
        super(message);
    }
}
