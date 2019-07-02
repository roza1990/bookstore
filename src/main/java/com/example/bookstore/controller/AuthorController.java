package com.example.bookstore.controller;

import com.example.bookstore.model.Author;
import com.example.bookstore.repositroy.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/author/add")
    public String addAuthorView() {
        return "addAuthor";
    }

    @PostMapping("/author/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/";
    }


}
