package com.application.bookstore.model;

import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Data : To Generate Getters and Setters
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDATA {
    AddressDTO addressDTO;
    Book book;
}
