package com.pergamum_library.pergamum_library.controllers;

import com.pergamum_library.pergamum_library.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class BooksLibraryController {

    static ArrayList<Book> database = new ArrayList<>();
    static {
        database.add(new Book("t1", "a1"));
        database.add(new Book("t2", "a2"));
    }

    @GetMapping("/books/")
    public List<Book> getBooks() {
        return database;
    }


}
