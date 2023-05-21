package com.example.BooksStore.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RoleDeserializer.class)
public enum Role {
    USER,
    ADMIN,
    GUEST
}
