package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repositroy.AuthorRepository;
import com.example.bookstore.repositroy.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/add")
    public ModelAndView addBookView(ModelAndView model) {
        model.addObject("authors", authorRepository.findAll());
        model.addObject(new Book());
        model.setViewName("addBook");
        return model;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") int id, ModelAndView model) {
        Optional<Book> bId = bookRepository.findById(id);
        model.addObject("authors", authorRepository.findAll());
        model.addObject(bId.get());
        model.setViewName("addBook");
        return model;
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addBook";

        }
        bookRepository.save(book);
        log.info("User successfully registreated!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id) {
        Optional<Book> one = bookRepository.findById(id);
        if (one.isPresent()) {
            bookRepository.deleteById(id);
        }
        return "redirect:/";
    }


    @GetMapping("/byAuthor")
    public String byAuthor(@RequestParam("authorId") int authorId, ModelMap modelMap) {
        modelMap.addAttribute("books", bookRepository.findAllByAuthorId(authorId));
        return "booksByAuthor";
    }

}

