package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
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
