package com.example.bookstorehome.service;

import com.example.bookstorehome.model.Book;

import java.util.List;

/**
 * Service Layer Interface
 */
public interface BookStoreHomeService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);

}
