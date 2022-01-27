package com.example.bookstorehome.controller;

import com.example.bookstorehome.dto.BookDTO;
import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.service.IBookStoreHomeService;
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
public class BookStoreHomeController {

    /**
     * Autowiring Service Interface for Dependency Injection
     */
    @Autowired
    IBookStoreHomeService iBookStoreHomeService;

    /**
     * API for adding book to DB
     * @param bookDTO
     * @return : Book Object
     */
    @PostMapping("/addbook")
    public Book addBook(@RequestBody BookDTO bookDTO){
        Book book = new Book(bookDTO);
        return iBookStoreHomeService.addBook(book);
    }

    /**
     * API for get Book Object by ID
     * @param id
     * @return : Book Object
     */
    @GetMapping("/getbyid/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return iBookStoreHomeService.getBookById(id);
    }

    /**
     * API for Getting all Books in Home Page
     * @return : Book Object
     */
    @GetMapping("/getallbooks")
    public List<Book> getAllBooks(){
        return iBookStoreHomeService.getAllBooks();
    }
}
