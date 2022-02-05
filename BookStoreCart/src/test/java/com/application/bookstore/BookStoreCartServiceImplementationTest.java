package com.application.bookstore;

import com.application.bookstore.controller.BookStoreCartController;
import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.model.AddBookToCart;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;
import com.application.bookstore.repository.BookStoreCartRepository;
import com.application.bookstore.repository.BookStoreUserRepository;
import com.application.bookstore.serviceimplementation.BookStoreCartServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookStoreCartServiceImplementationTest {
    @InjectMocks
    private BookStoreCartServiceImplementation bookStoreCartServiceImplementation;

    @Mock
    private BookStoreCartRepository bookStoreCartRepository;

    @Mock
    private BookStoreUserRepository bookStoreUserRepository;

    /*@Autowired*/
    private BookStoreCartController bookStoreCartController;

    User user = new User(1L,"8555058332","mohank5","kmohanr5@gmail.com");
    User user1 = new User(2L,"1234567890","mohank5","kmohanr5@gmail.com");
    User user2 = new User(3L,"0987626226","mohank5","kmohanr5@gmail.com");

    UserDTO userDTO = new UserDTO("8179800190","Dhoni","google.com");
    Book book1 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);
    Book book4 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);

    AddBookToCart addBookToCart = new AddBookToCart(book1,user.getID());

    @Test
    public void addBookToCart(){
        Mockito.when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Mockito.when(bookStoreCartRepository.save(Mockito.any(Book.class))).thenReturn(book1);
        Book book = bookStoreCartServiceImplementation.addBook(book1, user.getID());
        assertNotNull(book);
    }

    @Test
    public void removeFromCart(){
        when(bookStoreCartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(book1));
        bookStoreCartServiceImplementation.removeBookfromCart(anyLong());
        verify(bookStoreCartRepository,times(1)).deleteById(anyLong());
    }

    @Test
    public void getAllBooksPresentinCart(){
        Mockito.when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        List<Book> bookCart = new ArrayList<>();
        bookCart.add(book1);
        bookCart.add(book2);
        bookCart.add(book3);
        bookCart.add(book4);
        Mockito.when(bookStoreCartRepository.findAll()).thenReturn(bookCart);
        assertEquals(bookCart, bookStoreCartServiceImplementation.getAllBooksinCart());
    }

    @Test
    public void getAllBooksinCartByUserId(){
        Mockito.when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        List<Book> bookCart = new ArrayList<>();
        bookCart.add(book1);
        bookCart.add(book2);
        bookCart.add(book3);
        bookCart.add(book4);
        Mockito.when(bookStoreCartRepository.getBooksByUserID(user.getID())).thenReturn(bookCart);
        assertEquals(bookCart, bookStoreCartServiceImplementation.getBookCartbyUserid(user.getID()));
    }

    @Test
    public void deleteBooksByUserId(){
        when(bookStoreCartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(book1));
        bookStoreCartServiceImplementation.deleteBookByUserId(book1.getUser().getID());
        verify(bookStoreCartRepository,times(1)).deleteBooksByUserIDinCart(anyLong());
    }

    /**
     * UserException Related Testing
     */
    @Test
    public void registerUser(){
        Mockito.when(bookStoreUserRepository.save(Mockito.any(User.class))).thenReturn(user);
        User user = bookStoreCartServiceImplementation.createUser(user1);
        assertNotNull(user);
    }

    @Test
    public void deleteUser(){
        when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        bookStoreCartServiceImplementation.deletebyID(user.getID());
        verify(bookStoreUserRepository,times(1)).deleteById(user.getID());
    }

    @Test
    public void updateUser(){
        when(bookStoreUserRepository.getById(anyLong())).thenReturn((user));
        bookStoreCartServiceImplementation.updateUser(user.getID(),userDTO);
        Mockito.when(bookStoreUserRepository.save(any())).thenReturn(user);
        assertEquals(userDTO.getMobileNumber(),user.getMobileNumber());
    }

}
