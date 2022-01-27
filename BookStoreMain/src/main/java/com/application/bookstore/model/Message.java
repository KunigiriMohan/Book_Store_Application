package com.application.bookstore.model;

import lombok.Data;
/**
 * @Data : To Generate Getters and Setters
 */
@Data
public class Message {
    public static String userAlreadyPresent = "User Number Already Registered";
    public static String userRegitered = "User Created";
    public static String userNotRegistered = "User not Registered";
    public static String userUpdatedSucessfully = "User Detials Updated Successfully";
    public static String loginSuccesfull = "Login Sucessfull";
    public static String userDeletedSucessfully = "User Deleted Successfully";
    public static String allBooksinStore = "Books in Store";
    public static String loginToShowCart = "Login to Show Cart";
    public static String bookRemovedFromCart = "Book Removed From Cart Successfully";
    public static String bookNotFoundInCart = "Book not found";
    public static String noBookFoundinCart = "No Books Found in your Cart";
    public static String bookAddedToCart="Book Added To Cart";
    public static String booksInCart = "Books Present in Cart";
    public static String bookAddedForBuying = "Book Added For Buying";
    public static String loginToPerformOperations = "User need to Login to Perform this Operation";
}
