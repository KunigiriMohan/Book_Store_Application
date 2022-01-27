package com.example.bookstorehome.repository;

import com.example.bookstorehome.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreHomeRepository extends JpaRepository<Book, Long> {
}
