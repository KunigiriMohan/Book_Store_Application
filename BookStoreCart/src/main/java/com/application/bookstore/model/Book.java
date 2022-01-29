package com.application.bookstore.model;

import com.application.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @Data : Using lombok to autogenerate toString() , Getters and Setters.
 * @AllArgsContructor: To Create Constructor
 * @NoArgsConstructor : To Create No Constructor
 * @Table : Creating Table and Declaring Name
 * @Entity : To Create Entity of Class
 */
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
    private Long bookPrice;
    private String bookAuthor;
    private String publishedYear;

    @ManyToOne
    @JoinColumn(name = "fk_userID",referencedColumnName = "iD")
    private User user;

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
