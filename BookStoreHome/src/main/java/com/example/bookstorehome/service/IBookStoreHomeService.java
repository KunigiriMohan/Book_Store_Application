package com.example.bookstorehome.service;

import com.example.bookstorehome.model.Book;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IBookStoreHomeService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);

}
