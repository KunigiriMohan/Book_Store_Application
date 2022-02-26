package com.application.bookstore.controller;

import com.application.bookstore.dto.UpdateUserData;
import com.application.bookstore.model.AddBookToCart;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.serviceimplementation.BookStoreCartServiceImplementation;
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
    BookStoreCartServiceImplementation bookStoreCartServiceImplementation;

    @Autowired
    BookStoreCartRepository bookStoreCartRepository;

    /**
     * API for save Book in DB
     * @param : addBookToCart
     * @return : Object of added Book
     */
    @PostMapping("/addbook")
    public Book addBooktoCart(@RequestBody AddBookToCart addBookToCart){
        return bookStoreCartServiceImplementation.addBook(addBookToCart.getBook(),addBookToCart.getUserid());
    }

    /**
     * API for getting All Books in Cartt
     * @return : List Objects of Book in  Cart
     */
    @GetMapping("/booksincart/{id}")
    public List<Book> bookPresentinCart(@PathVariable("id") Long id){
        return bookStoreCartServiceImplementation.getBookCartbyUserid(id);
    }

    /**
     * API for Deleting Book from Cart
     * @param id
     */
    @DeleteMapping("/removebookfromcart/{id}")
    public void removeBookfromCart(@PathVariable("id") Long id){
        bookStoreCartServiceImplementation.removeBookfromCart(id);
    }

    /**
     * API to get total Value of all books present Cart
     * @return
     */
    @GetMapping("carttotal")
    public Long totalCartValue(){return bookStoreCartRepository.cartValue();}

    /**
     * API for registering UserException for App
     * @param user
     * @return : Creating UserException Data
     */
    @PostMapping("/registeruser")
    public User generateUser(@RequestBody User user){
        User userDetailUser = bookStoreCartServiceImplementation.createUser(user);
        return userDetailUser;
    }

    /**
     * API for Delete UserException by id
     * @param id
     * @throws EmptyResultDataAccessException
     */
    @DeleteMapping("/deletebyid/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        bookStoreCartServiceImplementation.deletebyID(id);
    }

    /**
     * API for update user
     * @param updateUserData
     * @return : object of user details
     */
    @PostMapping("updateuser")
    public User updateUser(@RequestBody UpdateUserData updateUserData){
        return bookStoreCartServiceImplementation.updateUser(updateUserData.getId(),updateUserData.getUserDTO());
    }

    /**
     * API to delete Book by Id
     * @param id
     */
    @DeleteMapping("/deletebookbyuserid/{id}")
    public void deleteBookbyUserID(@PathVariable("id") Long id){
        bookStoreCartServiceImplementation.deleteBookByUserId(id);
    }
}
