package com.application.bookstore.serviceimplementation;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.service.IBookStoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * */
@Service
public class BookStoreCartService implements IBookStoreCartService {

    /**
     * Autowiring Repository Interface to inject Book Object  to Save in DB
     */
    @Autowired
    BookStoreCartRepository bookStoreCartRepository;

    /**
     * Method to Add Book to Cart
     * @param bookDTO
     * @return : Object of added Book
     */
    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        return bookStoreCartRepository.save(book);

    }

    /**
     * Method to Remove Book From Cart
     * @param iD
     */
    @Override
    public void removeBookfromCart(Long iD) {
        bookStoreCartRepository.deleteById(iD);
    }

    /**
     * Method to get all Books in Cart
     * @return : List of Books present in Cart
     */
    @Override
    public List<Book> getAllBooksinCart() {
        return bookStoreCartRepository.findAll();
    }
}
