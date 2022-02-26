package com.application.bookstore;

import com.application.bookstore.controller.BookStoreCartController;
import com.application.bookstore.dto.UpdateUserData;
import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.model.AddBookToCart;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.serviceimplementation.BookStoreCartServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookStoreCartControllerTest {

    @InjectMocks
    BookStoreCartController bookStoreCartController;

    @Mock
    BookStoreCartServiceImplementation bookStoreCartServiceImplementation;

    @Mock
    BookStoreCartRepository bookStoreCartRepository;

    User user = new User(1L,"8555058332","mohank5","kmohanr5@gmail.com");
    User user1 = new User(2L,"1234567890","mohank5","kmohanr5@gmail.com");

    UserDTO userDTO = new UserDTO("8555058332","mohank5","google.com");

    Book book1 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);

    AddBookToCart addBookToCart1 = new AddBookToCart(book1,user.getID());

    UpdateUserData updateUserData = new UpdateUserData(user.getID(), userDTO);
    List<Book> booksInCart = new ArrayList<>();

    @Test
    public void addBookTOCart(){
        when(bookStoreCartServiceImplementation.addBook(Mockito.any(Book.class),Mockito.anyLong())).thenReturn(book1);
        Book book = bookStoreCartController.addBooktoCart(addBookToCart1);
        assertEquals(book1,book);
    }

    @Test
    public void booksPresentInCart(){
        booksInCart.add(book1);
        booksInCart.add(book2);
        booksInCart.add(book3);
        when(bookStoreCartServiceImplementation.getBookCartbyUserid(Mockito.anyLong())).thenReturn(booksInCart);
        List<Book> bookList = bookStoreCartController.bookPresentinCart(user.getID());
        assertEquals(booksInCart,bookList);
    }

    @Test
    public void removeBookFromCart(){
        bookStoreCartController.removeBookfromCart(anyLong());
        verify(bookStoreCartServiceImplementation,times(1)).removeBookfromCart(anyLong());
    }

    @Test
    public void getCartTotalValue(){
        Mockito.when(bookStoreCartRepository.cartValue()).thenReturn(10000L);
        Long cartValue = bookStoreCartController.totalCartValue();
        assertNotNull(cartValue);
    }

    @Test
    public void createUser(){
        when(bookStoreCartServiceImplementation.createUser(Mockito.any(User.class))).thenReturn(user);
        User userCreated = bookStoreCartController.generateUser(user);
        assertEquals(user,userCreated);
    }

    @Test
    public void deleteUserById(){
        bookStoreCartController.deleteUser(anyLong());
        verify(bookStoreCartServiceImplementation,times(1)).deletebyID(anyLong());
    }

    @Test
    public void updateUserById(){
        when(bookStoreCartServiceImplementation.updateUser(anyLong(),Mockito.any(UserDTO.class))).thenReturn(user);
        User userUpdated = bookStoreCartController.updateUser(updateUserData);
        assertEquals(user,userUpdated);
    }

    @Test
    public void deleteBookByUserId(){
        bookStoreCartController.deleteBookbyUserID(anyLong());
        verify(bookStoreCartServiceImplementation,times(1)).deleteBookByUserId(anyLong());
    }
}
