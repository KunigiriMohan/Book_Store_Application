package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserData {
    private Long id;
    private UserDTO userDTO;
}
