package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repositroy.AuthorRepository;
import com.example.bookstore.repositroy.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Maincontroller {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @GetMapping("/")
    public String main(ModelMap map) {
        List<Book> all = bookRepository.findAll();
        map.addAttribute("books", all);
        map.addAttribute("authors", authorRepository.findAll());
        return "index";
    }
}
