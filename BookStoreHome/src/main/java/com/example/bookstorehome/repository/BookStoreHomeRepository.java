package com.example.bookstorehome.repository;

import com.example.bookstorehome.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository : Creating Repository
 */
@Repository
public interface BookStoreHomeRepository extends JpaRepository<Book, Long> {
}
