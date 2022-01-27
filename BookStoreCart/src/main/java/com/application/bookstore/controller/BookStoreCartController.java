package com.application.bookstore.controller;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.serviceimplementation.BookStoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreCartController {

    @Autowired
    BookStoreCartService bookStoreCartService;

    @PostMapping("/addbook")
    public Book addBooktoCart(@RequestBody BookDTO bookDTO){
        return bookStoreCartService.addBook(bookDTO);
    }

    @GetMapping("/booksincart")
    public List<Book> bookPresentinCart(){
        return bookStoreCartService.getAllBooksinCart();
    }

    @DeleteMapping("/removebookfromcart/{id}")
    public void removeBookfromCart(@PathVariable("id") Long id){
        bookStoreCartService.removeBookfromCart(id);
    }
}
