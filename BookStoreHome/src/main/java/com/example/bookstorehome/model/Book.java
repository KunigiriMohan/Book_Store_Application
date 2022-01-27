package com.example.bookstorehome.model;

import com.example.bookstorehome.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "book_list")
@Data
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
