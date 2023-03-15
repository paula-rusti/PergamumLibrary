package com.pergamum_library.pergamum_library.repository;

import com.pergamum_library.pergamum_library.entities.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// will be implemented, instantiated and injected by spring in the controller
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAll(Sort sort); // used for getting all the books sorted by author and title

    Book findBookByTitle(String title); // used to retrieve a book from the library based on its name
}
