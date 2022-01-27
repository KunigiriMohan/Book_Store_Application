package com.application.bookstore.model;

import com.application.bookstore.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String mobileNumber;
    private String password;
    private String email;

    public User(UserDTO userDTO) {
        this.mobileNumber = userDTO.getMobileNumber();
        this.password = userDTO.getPassword();
        this.email = userDTO.getEmail();
    }
}
