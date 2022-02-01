package com.application.bookstore;

import com.application.bookstore.controller.BookStoreBuyNowController;
import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.model.OrderDATACart;
import com.application.bookstore.repository.BookStoreBuyNowRepository;
import com.application.bookstore.service.IBookStoreBuyNowService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookStoreBuyNowControllerTest {

    @Mock
    IBookStoreBuyNowService iBookStoreBuyNowService;

    @InjectMocks
    BookStoreBuyNowController bookStoreBuyNowController;

    @Mock
    BookStoreBuyNowRepository bookStoreBuyNowRepository;

    Book book1 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book4 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");

    AddressDTO addressDTO = new AddressDTO("Mohan","5/223","adoni","Andhra Pradesh","518301","8555058332");

    OrderDATA orderDATA = new OrderDATA(addressDTO,book1);



    Book bookInCart[] = {book1,book2,book3,book4};
    List<Book> bookList = new ArrayList<>();

    OrderDATACart orderDATACart = new OrderDATACart(addressDTO,bookInCart);

    @Test
    public void buyNow(){
        when(iBookStoreBuyNowService.buyNow(Mockito.any(OrderDATA.class))).thenReturn(book1);
        Book bookBuyed=bookStoreBuyNowController.buyNow(orderDATA);
        assertEquals(book1,bookBuyed);
    }

    @Test
    public void buyNowInCart(){
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        when(iBookStoreBuyNowService.buyNowBooksinCart(Mockito.any(OrderDATACart.class))).thenReturn(bookList);
        List<Book> booksPresentInCart = bookStoreBuyNowController.buyNowBooksinCart(orderDATACart);
        assertEquals(bookList,booksPresentInCart);
    }

    @Test
    public void cartValue(){
        when(bookStoreBuyNowRepository.cartValue()).thenReturn(100L);
        Long cartValue= bookStoreBuyNowController.totalCartValue();
        assertNotNull(cartValue);
    }
}
