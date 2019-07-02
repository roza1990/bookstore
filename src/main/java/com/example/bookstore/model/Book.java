package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column

    private int id;
    @Column
    @NotEmpty(message = "Title may not be empty")
    private String title;
    @Column(columnDefinition = "text")
    @NotEmpty(message = "Description may not be empty")
    private String description;
    @ManyToOne
    private Author author;
}
