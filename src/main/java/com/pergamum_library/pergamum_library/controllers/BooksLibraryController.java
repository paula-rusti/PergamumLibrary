package com.pergamum_library.pergamum_library.controllers;

import com.pergamum_library.pergamum_library.entities.Book;
import com.pergamum_library.pergamum_library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksLibraryController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/")
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @PostMapping("/books/")
    public Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }


}
