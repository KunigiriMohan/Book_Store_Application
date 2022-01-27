package com.application.bookstoresuser.controller;

import com.application.bookstoresuser.dto.UpdateUserData;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.service.IBookStoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookStoreController {
    @Autowired
    IBookStoreUserService iBookStoreUserService;

    @PostMapping("/registeruser")
    public User generateUser(@RequestBody User user){
        User userDetailUser = iBookStoreUserService.createUser(user);
        return userDetailUser;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        String userDetailUser = iBookStoreUserService.generateToken(user);
        return userDetailUser;
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws EmptyResultDataAccessException {
        iBookStoreUserService.deletebyID(id);
    }

    @PostMapping("updateuser")
    public User updateUser(@RequestBody UpdateUserData updateUserData){
        return iBookStoreUserService.updateUser(updateUserData.getId(),updateUserData.getUserDTO());
    }
}
