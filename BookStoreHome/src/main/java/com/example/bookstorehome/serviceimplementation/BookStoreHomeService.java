package com.example.bookstorehome.serviceimplementation;

import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.repository.BookStoreHomeRepository;
import com.example.bookstorehome.service.IBookStoreHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreHomeService implements IBookStoreHomeService {

    @Autowired
    BookStoreHomeRepository bookStoreHomeRepository;

    @Override
    public Book addBook(Book book) {
        return bookStoreHomeRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookStoreHomeRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookStoreHomeRepository.findById(id).get();
    }
}
