package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "User name is Invalid")
    private String name;

    @NotNull(message = "State name should not empty")
    private String address;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "City name is Invalid")
    private String city;

    @Pattern(regexp = "^[A-Z]{1}[a-z\\sA-Z]{2,}$", message = "State name is Invalid")
    @NotNull(message = "State name should not empty")
    private String state;

    @Pattern(regexp = "^[1-9]{1}[0-9]{5}")
    private String pinCode;

    @Pattern(regexp = "^[6-9]{1}[0-9]{9,}$", message = "Phone Number is invalid")
    @NotNull(message = "Phone Number can not be null")
    private String mobileNumber;
}
