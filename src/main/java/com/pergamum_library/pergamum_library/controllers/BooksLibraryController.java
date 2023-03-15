package com.pergamum_library.pergamum_library.controllers;

import com.pergamum_library.pergamum_library.entities.Book;
import com.pergamum_library.pergamum_library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksLibraryController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/books/")
    public Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/books/")
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll(Sort.by("author", "title"));
    }

    @GetMapping("/books/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return (List<Book>) this.bookRepository.findBookByTitle(title);
    }



}
