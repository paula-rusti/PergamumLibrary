package com.pergamum_library.pergamum_library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksLibraryController {
    @GetMapping("/books/")
    public String getBooks() {
        return "I will return all the books";
    }
}
