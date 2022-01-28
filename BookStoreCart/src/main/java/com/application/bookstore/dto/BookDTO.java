package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Data : Using lombok to autogenerate toString() , Getters and Setters.
 * @AllArgsContructor: To Create Constructor
 * @NoArgsConstructor : To Create No Constructor
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private String bookName;
    private Long bookPrice;
    private String bookAuthor;
    private String publishedYear;
}