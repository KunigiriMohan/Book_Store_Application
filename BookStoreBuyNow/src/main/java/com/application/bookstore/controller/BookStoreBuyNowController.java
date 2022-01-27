package com.application.bookstore.controller;

import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.model.OrderDATACart;
import com.application.bookstore.service.IBookStoreBuyNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreBuyNowController {

    @Autowired
    IBookStoreBuyNowService iBookStoreBuyNowService;

    @PostMapping("/buynow")
    public Book buyNow(@RequestBody OrderDATA orderDATA){
        return iBookStoreBuyNowService.buyNow(orderDATA);
    }

    @PostMapping("/buyallproductsincart")
    public List<Book> buyNowBooksinCart(@RequestBody OrderDATACart orderDATACart){
        return iBookStoreBuyNowService.buyNowBooksinCart(orderDATACart);
    }
}
