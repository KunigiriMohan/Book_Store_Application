package com.application.bookstore.serviceimplementation;

import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.dto.Message;
import com.application.bookstore.model.Address;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.model.OrderDATACart;
import com.application.bookstore.repository.BookStoreBuyNowAddressRepository;
//import com.application.bookstore.repository.BookStoreBuyNowCartBooksRepository;
import com.application.bookstore.repository.BookStoreBuyNowRepository;
import com.application.bookstore.service.IBookStoreBuyNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookStoreBuNowService implements IBookStoreBuyNowService {

    @Autowired
    BookStoreBuyNowAddressRepository bookStoreBuyNowAddressRepository;

    @Autowired
    BookStoreBuyNowRepository bookStoreBuyNowRepository;

    @Override
    public Book buyNow(OrderDATA orderDATA) {
        Address address = new Address(orderDATA.getAddressDTO());
        bookStoreBuyNowAddressRepository.save(address);
        //Book book = new Book(bookDTO);
        bookStoreBuyNowRepository.save(orderDATA.getBook());
        return bookStoreBuyNowRepository.save(orderDATA.getBook());
    }

    @Override
    public List<Book> buyNowBooksinCart(OrderDATACart orderDATACart) {
        Address address = new Address(orderDATACart.getAddressDTO());
        bookStoreBuyNowAddressRepository.save(address);
        bookStoreBuyNowRepository.saveAll(Arrays.asList(orderDATACart.getBook()));
        return bookStoreBuyNowRepository.saveAll(Arrays.asList(orderDATACart.getBook()));
    }
}
