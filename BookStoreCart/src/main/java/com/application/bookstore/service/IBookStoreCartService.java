package com.application.bookstore.service;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.model.Book;
import java.util.List;

/**
 * Service Layer Interface
 */
public interface IBookStoreCartService {
    Book addBook(BookDTO bookDTO);
    void removeBookfromCart(Long iD);
    List<Book> getAllBooksinCart();
}
