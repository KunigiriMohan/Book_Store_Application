package com.application.bookstore.repository;

import com.application.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreCartRepository extends JpaRepository<Book,Long> {
}
