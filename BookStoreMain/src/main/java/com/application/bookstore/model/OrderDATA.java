package com.application.bookstore.model;

import com.application.bookstore.dto.AddressDTO;
import lombok.Data;

/**
 * @Data : To Generate Getters and Setters
 */
@Data
public class OrderDATA {
    AddressDTO addressDTO;
    Book book;
}
