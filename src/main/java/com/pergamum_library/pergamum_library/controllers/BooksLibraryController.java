package com.pergamum_library.pergamum_library.controllers;

import com.pergamum_library.pergamum_library.dtos.BookUpdateAuthor;
import com.pergamum_library.pergamum_library.entities.Book;
import com.pergamum_library.pergamum_library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        this.bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody BookUpdateAuthor bookUpdateAuthor) {
        Optional<Book> book = this.bookRepository.findById(id);
        if (book.isPresent()) {

            Book bookEntity = book.get();
            bookEntity.setAuthor(bookUpdateAuthor.author());

            this.bookRepository.save(bookEntity);

            return ResponseEntity.ok(bookEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
