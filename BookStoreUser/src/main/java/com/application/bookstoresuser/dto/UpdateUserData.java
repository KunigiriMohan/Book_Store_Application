package com.application.bookstoresuser.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserData {
    private Long id;
    private UserDTO userDTO;
}