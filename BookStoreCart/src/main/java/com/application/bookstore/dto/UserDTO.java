package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String mobileNumber;
    private String password;
    private String email;
}