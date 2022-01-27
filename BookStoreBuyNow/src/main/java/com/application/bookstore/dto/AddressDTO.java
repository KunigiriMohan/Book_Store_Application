package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {
    private String name;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String mobileNumber;
}
