package com.example.BooksStore.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String category;
    private Integer publishedYear;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

}
