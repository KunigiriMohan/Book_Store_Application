package com.application.bookstore.controller;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.serviceimplementation.BookStoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController : Defining Class as a RestController
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @Autowired : Dependency Injection
 */
@RestController
public class BookStoreCartController {

    /**
     * Autowiring Service Interface for Dependency Injection
     */
    @Autowired
    BookStoreCartService bookStoreCartService;

    /**
     * API for save Book in DB
     * @param bookDTO
     * @return : Object of added Book
     */
    @PostMapping("/addbook")
    public Book addBooktoCart(@RequestBody BookDTO bookDTO){
        return bookStoreCartService.addBook(bookDTO);
    }

    /**
     * API for getting All Books in Cartt
     * @return : List Objects of Book in Cart
     */
    @GetMapping("/booksincart")
    public List<Book> bookPresentinCart(){
        return bookStoreCartService.getAllBooksinCart();
    }

    /**
     * API for Deleting Book from Cart
     * @param id
     */
    @DeleteMapping("/removebookfromcart/{id}")
    public void removeBookfromCart(@PathVariable("id") Long id){
        bookStoreCartService.removeBookfromCart(id);
    }
}
