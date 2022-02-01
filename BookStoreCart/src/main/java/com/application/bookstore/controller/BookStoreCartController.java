package com.application.bookstore.controller;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.dto.UpdateUserData;
import com.application.bookstore.model.AddBookToCart;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.serviceimplementation.BookStoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Autowired
    BookStoreCartRepository bookStoreCartRepository;

    /**
     * API for save Book in DB
     * @param
     * @return : Object of added Book
     */
    @PostMapping("/addbook")
    public Book addBooktoCart(@RequestBody AddBookToCart addBookToCart){
        return bookStoreCartService.addBook(addBookToCart.getBook(),addBookToCart.getUserid());
    }

    /**
     * API for getting All Books in Cartt
     * @return : List Objects of Book in  Cart
     */
    @GetMapping("/booksincart/{id}")
    public List<Book> bookPresentinCart(@PathVariable("id") Long id){
        return bookStoreCartService.getBookCartbyUserid(id);
    }

    /**
     * API for Deleting Book from Cart
     * @param id
     */
    @DeleteMapping("/removebookfromcart/{id}")
    public void removeBookfromCart(@PathVariable("id") Long id){
        bookStoreCartService.removeBookfromCart(id);
    }

    @GetMapping("carttotal")
    public Long totalCartValue(){return bookStoreCartRepository.cartValue();}

    /**
     * API for registering User for App
     * @param user
     * @return : Creating User Data
     */
    @PostMapping("/registeruser")
    public User generateUser(@RequestBody User user){
        User userDetailUser = bookStoreCartService.createUser(user);
        return userDetailUser;
    }

    /**
     * API for Delete User by id
     * @param id
     * @throws EmptyResultDataAccessException
     */
    @DeleteMapping("/deletebyid/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        bookStoreCartService.deletebyID(id);
    }

    /**
     * API for update user
     * @param updateUserData
     * @return : object of user details
     */
    @PostMapping("updateuser")
    public User updateUser(@RequestBody UpdateUserData updateUserData){
        return bookStoreCartService.updateUser(updateUserData.getId(),updateUserData.getUserDTO());
    }

    @DeleteMapping("/deletebookbyuserid/{id}")
    public void deleteBookbyUserID(@PathVariable("id") Long id){
        bookStoreCartService.deleteBookByUserId(id);
    }
}
