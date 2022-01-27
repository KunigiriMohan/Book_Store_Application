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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Pattern(regexp = "^[6-9]{1}[0-9]{9,}$", message = "Phone Number is invalid")
    @NotNull(message = "Phone Number can not be null")
    private String mobileNumber;

    @Pattern(regexp = "^[A-za-z0-9]{1,}$", message = "Password Number is invalid")
    private String password;

    //@Pattern(regexp = "^[a-zA-Z0-9_+/#$%?~.-]+@[a-zA-Z0-9.-]+$", message = "Email is invalid")
    //@NotNull(message = "Email should not empty")
    private String email;
}
