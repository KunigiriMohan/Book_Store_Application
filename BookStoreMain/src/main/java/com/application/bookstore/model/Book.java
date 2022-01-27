package com.application.bookstore.model;

import com.application.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Book {

    private Long id;
    private String bookName;
    private String bookPrice;
    private String bookAuthor;
    private String publishedYear;

    public Book(BookDTO bookDTO){
        this.updateBookDetails(bookDTO);
    }

    public void updateBookDetails(BookDTO bookDTO){
        this.bookName = bookDTO.getBookName();
        this.bookPrice = bookDTO.getBookPrice();
        this.bookAuthor = bookDTO.getBookAuthor();
        this.publishedYear = bookDTO.getPublishedYear();
    }
}
