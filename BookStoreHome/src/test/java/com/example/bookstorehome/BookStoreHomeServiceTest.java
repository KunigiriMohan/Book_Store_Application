package com.example.bookstorehome;

import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.repository.BookStoreHomeRepository;
import com.example.bookstorehome.serviceimplementation.BookStoreHomeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class BookStoreHomeServiceTest {
    @Mock
    BookStoreHomeRepository bookStoreHomeRepository;

    @InjectMocks
    BookStoreHomeService bookStoreHomeService;

    Book book1 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book4 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");

    /**
     * Service Layer Testing
     */

    @Test
    public void getAllBooks(){
        List<Book> bookCart = new ArrayList<>();
        bookCart.add(book1);
        bookCart.add(book2);
        bookCart.add(book3);
        bookCart.add(book4);
        Mockito.when(bookStoreHomeRepository.findAll()).thenReturn(bookCart);
        List<Book> bookList = bookStoreHomeService.getAllBooks();
        assertEquals(bookCart,bookList);
    }

    @Test
    public void getBooksById(){
        Mockito.when(bookStoreHomeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(book1));
        Book book = bookStoreHomeService.getBookById(book1.getId());
        assertEquals(book1,book);
    }
}
