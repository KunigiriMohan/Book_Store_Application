package com.application.bookstore.serviceimplementation;

import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.exception.BookStoreException;
import com.application.bookstore.exception.UserException;
import com.application.bookstore.model.Book;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.repository.BookStoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * */
@Service
public class BookStoreCartServiceImplementation implements com.application.bookstore.service.BookStoreCartService {

    /**
     * Autowiring Repository Interface to inject Book Object  to Save in DB
     */
    @Autowired
    BookStoreCartRepository bookStoreCartRepository;

    @Autowired
    BookStoreUserRepository bookStoreUserRepository;

    /**
     * Method to Add Book to Cart
     * @param book
     * @return : Object of added Book
     */
    @Override
    public Book addBook(Book book,Long userId) {
        Optional<com.application.bookstore.model.User> user = bookStoreUserRepository.findById(userId);
        if(user.isPresent()){
            book.setUser(user.get());
        }
        else{
            throw new BookStoreException("UserException not found");
        }
        return bookStoreCartRepository.save(book);
    }

    /**
     * Method to Remove Book From Cart
     * @param iD
     */
    @Override
    public void removeBookfromCart(Long iD) {
        try{
            bookStoreCartRepository.deleteById(iD);
        }catch (Exception exception){
            throw new BookStoreException("Book Not Found");
        }
    }

    /**
     * Method to get all Books in Cart
     * @return : List of Books present in Cart
     */
    @Override
    public List<Book> getAllBooksinCart() {
        return bookStoreCartRepository.findAll();
    }


    /***
     * Method to register user
     * @param user
     * @return : Object of registered user
     */
    @Override
    public com.application.bookstore.model.User createUser(com.application.bookstore.model.User user){
        if(bookStoreUserRepository.findAll().size()==0){
            return bookStoreUserRepository.save(user);
        }
        else{
            com.application.bookstore.model.User userDetails=bookStoreUserRepository.getUserDetails(user.getMobileNumber());
            if(userDetails==null){
                return bookStoreUserRepository.save(user);
            }
            else{
                throw new UserException("UserException Already Present");
            }
        }
    }
    /**
     * Method to Delete UserException by id
     * @param id
     */
    @Override
    public void deletebyID(Long id) {
        try{
            bookStoreUserRepository.deleteById(id);
        }
        catch (Exception exception){
            throw new UserException("UserException Not Found");
        }
    }

    /**
     * Method to update UserException Details
     * @param id
     * @param userDTO
     * @return
     */
    @Override
    public com.application.bookstore.model.User updateUser(Long id, UserDTO userDTO) {
        try{
            com.application.bookstore.model.User user = bookStoreUserRepository.getById(id);
            user.updateUser(userDTO);
            return bookStoreUserRepository.save(user);
        }catch (Exception exception){
            throw new UserException("User Not Found");
        }
    }

    /**
     * Method to get List Books present in cart of user
     * @param id
     * @return : List of Books
     */
    @Override
    public List<Book> getBookCartbyUserid(Long id) {
        try {
            return bookStoreCartRepository.getBooksByUserID(id);
        }catch (Exception exception){
            throw new UserException("User Not Found");
        }
    }

    /**
     * Method to delete Book in cart by using Userid
     * @param id
     */
    @Override
    public void deleteBookByUserId(Long id) {
        try {
            bookStoreCartRepository.deleteBooksByUserIDinCart(id);
        }catch (Exception exception){
            throw new BookStoreException("Book Not Found");
        }
    }

}
