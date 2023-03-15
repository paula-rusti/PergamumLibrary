package com.pergamum_library.pergamum_library.repository;

import com.pergamum_library.pergamum_library.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// will be implemented, instantiated and injected by spring in the controller
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAll();
}
