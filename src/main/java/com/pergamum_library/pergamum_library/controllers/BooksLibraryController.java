package com.pergamum_library.pergamum_library.controllers;

import com.pergamum_library.pergamum_library.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksLibraryController {

    static ArrayList<Book> database = new ArrayList<>();

    @GetMapping("/books/")
    public List<Book> getBooks() {
        return database;
    }

    @PostMapping("/books/")
    public Book addBook(@RequestBody Book book) {
        database.add(book);
        return book;
    }
}
