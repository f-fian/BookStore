package com.example.BooksStore.dto;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class RoleDeserializer extends JsonDeserializer<Role> {
    @Override
    public Role deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String roleString = jsonParser.getText().toUpperCase();
        try {
            return Role.valueOf(roleString);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid role: " + roleString);
        }
    }
}
