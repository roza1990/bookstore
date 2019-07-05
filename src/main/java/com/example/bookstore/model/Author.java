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
   
    private String name;
    @Column
   
    private String surname;
    @Column
    
  
    private String email;
    @Column
   
    private int age;
    
     @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Book> books;

}
