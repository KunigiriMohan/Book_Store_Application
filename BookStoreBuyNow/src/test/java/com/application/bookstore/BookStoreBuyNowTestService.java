package com.application.bookstore;

import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.model.Address;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.repository.BookStoreBuyNowAddressRepository;
import com.application.bookstore.repository.BookStoreBuyNowRepository;
import com.application.bookstore.serviceimplementation.BookStoreBuNowService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class BookStoreBuyNowTestService {
    @Mock
    BookStoreBuyNowRepository bookStoreBuyNowRepository;

    @InjectMocks
    BookStoreBuNowService bookStoreBuNowService;

    @Mock
    BookStoreBuyNowAddressRepository bookStoreBuyNowAddressRepository;

    Book book1 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");
    Book book4 =new Book(1L,"The Intelligent Investor",100L,"graham","2014");

    AddressDTO addressDTO = new AddressDTO("Mohan","5/223","adoni","Andhra Pradesh","518301","8555058332");

    OrderDATA orderDATA = new OrderDATA(addressDTO,book1);

    @Test
    public void buyNow(){
        Mockito.when(bookStoreBuyNowAddressRepository.save(Mockito.any(Address.class))).thenReturn(new Address(addressDTO));
        Mockito.when(bookStoreBuyNowRepository.save(Mockito.any(Book.class))).thenReturn(book1);
        Book book = bookStoreBuNowService.buyNow(orderDATA);
        assertNotNull(book);
    }

   /* @Test
    public void buyNowBooksinCart(){
        Mockito.when(bookStoreBuyNowAddressRepository.save(Mockito.any(Address.class))).thenReturn(new Address(addressDTO));
        List<Book> bookCart = new ArrayList<>();
        bookCart.add(book1);
        bookCart.add(book2);
        bookCart.add(book3);
        bookCart.add(book4);
        Mockito.when(bookStoreBuyNowRepository.saveAll(Mockito.any(.clas))).thenReturn(bookCart);
    }*/

}
