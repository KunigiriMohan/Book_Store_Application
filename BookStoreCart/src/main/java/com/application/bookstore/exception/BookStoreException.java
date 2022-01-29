package com.application.bookstore.exception;

/**
 * Custom Exeption of Application
 */
public class BookStoreException extends  RuntimeException{
    public BookStoreException(String message){
        super(message);
    }
}
