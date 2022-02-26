package com.application.bookstoresuser.service;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.model.User;

/**
 * Service Layer Interface
 */
public interface BookStoreUserService {
    public User createUser(User user);
    public String generateToken(User user);
    public void deletebyID(Long id);
    public User updateUser(Long id, UserDTO userDTO);
    User getUserByID(Long id);
}
