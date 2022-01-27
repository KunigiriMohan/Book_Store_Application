package com.application.bookstore.serviceimplementation;

import com.application.bookstore.dto.BookDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.service.IBookStoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreCartService implements IBookStoreCartService {

    @Autowired
    BookStoreCartRepository bookStoreCartRepository;

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        return bookStoreCartRepository.save(book);

    }

    @Override
    public void removeBookfromCart(Long iD) {
        bookStoreCartRepository.deleteById(iD);
    }

    @Override
    public List<Book> getAllBooksinCart() {
        return bookStoreCartRepository.findAll();
    }
}
