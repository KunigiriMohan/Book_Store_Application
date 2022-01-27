package com.example.bookstorehome.controller;

import com.example.bookstorehome.dto.BookDTO;
import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.service.IBookStoreHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreHomeController {

    @Autowired
    IBookStoreHomeService iBookStoreHomeService;

    @PostMapping("/addbook")
    public Book addBook(@RequestBody BookDTO bookDTO){
        Book book = new Book(bookDTO);
        return iBookStoreHomeService.addBook(book);
    }

    @GetMapping("/getbyid/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return iBookStoreHomeService.getBookById(id);
    }

    @GetMapping("/getallbooks")
    public List<Book> getAllBooks(){
        return iBookStoreHomeService.getAllBooks();
    }
}
