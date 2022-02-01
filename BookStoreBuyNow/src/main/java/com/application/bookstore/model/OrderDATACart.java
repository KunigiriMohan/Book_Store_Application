package com.application.bookstore.model;

import com.application.bookstore.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Data : to Generate Getters and Setters
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDATACart {
    AddressDTO addressDTO;
    Book[] book;
}
