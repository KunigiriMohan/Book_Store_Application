package com.application.bookstore.model;

import com.application.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Book {

    private Long id;
    private String bookName;
    private Long bookPrice;
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
