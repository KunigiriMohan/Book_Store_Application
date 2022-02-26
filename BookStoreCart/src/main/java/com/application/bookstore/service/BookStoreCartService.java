package com.application.bookstore.service;

import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;

import java.util.List;

/**
 * Service Layer Interface
 */
public interface BookStoreCartService {
    public User createUser(User user);
    Book addBook(Book book,Long  userId);
    void removeBookfromCart(Long iD);
    List<Book> getAllBooksinCart();
    public void deletebyID(Long id);
    public User updateUser(Long id, UserDTO userDTO);
    List<Book> getBookCartbyUserid(Long id);
    void deleteBookByUserId(Long id);
}
