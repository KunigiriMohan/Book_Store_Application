package com.application.bookstore.controller;

import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.model.OrderDATACart;
import com.application.bookstore.service.IBookStoreBuyNowService;
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
public class BookStoreBuyNowController {

    /**
     * Autowiring Service Interface for Dependency Injection
     */
    @Autowired
    IBookStoreBuyNowService iBookStoreBuyNowService;

    /**
     * API for buying Book from Home page using id
     * @param orderDATA
     * @return
     */
    @PostMapping("/buynow")
    public Book buyNow(@RequestBody OrderDATA orderDATA){
        return iBookStoreBuyNowService.buyNow(orderDATA);
    }

    /**
     * API for buying Books present in Cart
     * @param orderDATACart
     * @return
     */
    @PostMapping("/buyallproductsincart")
    public List<Book> buyNowBooksinCart(@RequestBody OrderDATACart orderDATACart){
        return iBookStoreBuyNowService.buyNowBooksinCart(orderDATACart);
    }
}
