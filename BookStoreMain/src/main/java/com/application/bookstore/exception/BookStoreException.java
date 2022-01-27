package com.application.bookstore.exception;

/**
 * Custom Exception
 */
public class BookStoreException extends  RuntimeException{
    public BookStoreException(String message){
        super(message);
    }
}
