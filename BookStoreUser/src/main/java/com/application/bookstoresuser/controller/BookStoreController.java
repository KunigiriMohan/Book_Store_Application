package com.application.bookstoresuser.controller;

import com.application.bookstoresuser.dto.UpdateUserData;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.service.IBookStoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 */
@RestController
public class BookStoreController {
    /**
     * Autowiring for Dependency Injection
     */
    @Autowired
    IBookStoreUserService iBookStoreUserService;

    /**
     * API for registering User for App
     * @param user
     * @return : Creating User Data
     */
    @PostMapping("/registeruser")
    public User generateUser(@RequestBody User user){
        User userDetailUser = iBookStoreUserService.createUser(user);
        return userDetailUser;
    }

    /**
     * API for Login User
     * @param user
     * @return : token
     */
    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        String userDetailUser = iBookStoreUserService.generateToken(user);
        return userDetailUser;
    }

    /**
     * API for Delete User by id
     * @param id
     * @throws EmptyResultDataAccessException
     */
    @DeleteMapping("/deletebyid/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws EmptyResultDataAccessException {
        iBookStoreUserService.deletebyID(id);
    }

    /**
     * API for update user
     * @param updateUserData
     * @return : object of user details
     */
    @PostMapping("updateuser")
    public User updateUser(@RequestBody UpdateUserData updateUserData){
        return iBookStoreUserService.updateUser(updateUserData.getId(),updateUserData.getUserDTO());
    }

    @GetMapping("/getuserbyid/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return iBookStoreUserService.getUserByID(id);
    }
}
