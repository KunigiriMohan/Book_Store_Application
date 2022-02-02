package com.example.bookstorehome.serviceimplementation;

import com.example.bookstorehome.exception.BookStoreHomeException;
import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.repository.BookStoreHomeRepository;
import com.example.bookstorehome.service.IBookStoreHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 *
 * */
@Service
public class BookStoreHomeService implements IBookStoreHomeService {

    /**
     * Autowiring Repository Interface to inject Address Object  to Save in DB
     */
    @Autowired
    BookStoreHomeRepository bookStoreHomeRepository;

    /**
     * Method to Save Book Object in DB
     * @param book
     * @return : Object of Added Book
     */
    /*@Override
    public Book addBook(Book book) {
        return bookStoreHomeRepository.save(book);
    }*/

    /**
     * Method to get all books in Home page
     * @return : Object of Book
     */
    @Override
    public List<Book> getAllBooks() {
        return bookStoreHomeRepository.findAll();
    }

    /**
     * Method to get Book Object by Id from Home Page
     * @param id
     * @return : Book
     */
    @Override
    public Book getBookById(Long id) {
        try{
            return bookStoreHomeRepository.findById(id).get();
        }catch (Exception e){
            throw new BookStoreHomeException("Book Not Found ");
        }
    }
}
