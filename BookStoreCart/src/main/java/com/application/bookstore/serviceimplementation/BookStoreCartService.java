package com.application.bookstore.serviceimplementation;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.exception.BookStoreException;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.repository.BookStoreUserRepository;
import com.application.bookstore.service.IBookStoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * */
@Service
public class BookStoreCartService implements IBookStoreCartService {

    /**
     * Autowiring Repository Interface to inject Book Object  to Save in DB
     */
    @Autowired
    BookStoreCartRepository bookStoreCartRepository;

    @Autowired
    BookStoreUserRepository bookStoreUserRepository;

    /**
     * Method to Add Book to Cart
     * @param bookDTO
     * @return : Object of added Book
     */
    @Override
    public Book addBook(Book book,Long userId) {
        Optional<User> user = bookStoreUserRepository.findById(userId);
        if(user.isPresent()){
            book.setUser(user.get());
        }
        else{
            throw new BookStoreException("User not found");
        }
        return bookStoreCartRepository.save(book);
    }

    /**
     * Method to Remove Book From Cart
     * @param iD
     */
    @Override
    public void removeBookfromCart(Long iD) {
        bookStoreCartRepository.deleteById(iD);
    }

    /**
     * Method to get all Books in Cart
     * @return : List of Books present in Cart
     */
    @Override
    public List<Book> getAllBooksinCart() {
        return bookStoreCartRepository.findAll();
    }

    /**
     * implementing method creatingUser in DB
     */
    @Override
    public User createUser(User user){
        if(bookStoreUserRepository.findAll().size()==0){
            return bookStoreUserRepository.save(user);
        }
        else{
            User userDetails=bookStoreUserRepository.getUserDetails(user.getMobileNumber());
            if(userDetails==null){
                return bookStoreUserRepository.save(user);
            }
            else{
                throw new BookStoreException("User Already Present");
            }
        }
    }
    /**
     * Method to Delete User by id
     * @param id
     */
    @Override
    public void deletebyID(Long id) {
        bookStoreUserRepository.deleteById(id);
    }

    /**
     * Method to update User Details
     * @param id
     * @param userDTO
     * @return
     */
    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User user = bookStoreUserRepository.getById(id);
        user.updateUser(userDTO);
        return bookStoreUserRepository.save(user);
    }

    @Override
    public List<Book> getBookCartbyUserid(Long id) {
        return bookStoreCartRepository.getBooksByUserID(id);
    }

    @Override
    public void deleteBookByUserId(Long id) {
        bookStoreCartRepository.deleteBooksByUserIDinCart(id);
    }

}
