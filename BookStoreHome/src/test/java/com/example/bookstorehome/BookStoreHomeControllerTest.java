package com.example.bookstorehome;

import com.example.bookstorehome.controller.BookStoreHomeController;
import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.service.IBookStoreHomeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookStoreHomeControllerTest {

    @Mock
    IBookStoreHomeService iBookStoreHomeService;

    @InjectMocks
    BookStoreHomeController bookStoreHomeController;

    Book book1 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book4 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");

    List<Book> bookList = new ArrayList<>();

    @Test
    public void getBookById(){
        when(iBookStoreHomeService.getBookById(anyLong())).thenReturn(book1);
        Book bookFromHome = bookStoreHomeController.getBookById(anyLong());
        assertEquals(book1,bookFromHome);
    }

    @Test
    public void getAllBooks(){
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        when(iBookStoreHomeService.getAllBooks()).thenReturn(bookList);
        List<Book> booksInCart = bookStoreHomeController.getAllBooks();
        assertEquals(bookList,booksInCart);
    }
}
