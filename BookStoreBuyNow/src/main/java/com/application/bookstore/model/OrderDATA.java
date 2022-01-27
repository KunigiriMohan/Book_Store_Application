package com.application.bookstore.model;

import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.dto.BookDTO;
import lombok.Data;

import java.util.List;

/**
 * @Data : To Generate Getters and Setters
 */
@Data
public class OrderDATA {
    AddressDTO addressDTO;
    Book book;
}
