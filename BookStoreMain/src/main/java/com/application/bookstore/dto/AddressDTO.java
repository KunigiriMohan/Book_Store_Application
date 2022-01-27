package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 */

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
