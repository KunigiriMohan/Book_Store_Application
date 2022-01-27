package com.application.bookstoresuser.service;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.model.User;

public interface IBookStoreUserService {
    public User createUser(User user);
    public String generateToken(User user);
    public void deletebyID(Long id);
    public User updateUser(Long id, UserDTO userDTO);
}
