package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @NotEmpty(message = "Name may not be empty")
    private String name;
    @Column
    @NotEmpty(message = "Surname may not be empty")
    private String surname;
    @Column
    @NotEmpty(message = "Email may not be empty")
    @Email
    private String email;
    @Column
    @NotEmpty(message = "Age may not be empty")
    private int age;

}
