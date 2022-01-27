package com.application.bookstore.service;

import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.model.OrderDATACart;

import java.util.List;

/**
 * Service Layer Interface
 */
public interface IBookStoreBuyNowService {
    Book buyNow(OrderDATA orderDATA);
    List<Book> buyNowBooksinCart(OrderDATACart orderDATACart);
}
