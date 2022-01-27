package com.application.bookstore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @SpringBootApplication : Spring Boot Main Application
 */
@Slf4j
@SpringBootApplication
public class BookStoreMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreMainApplication.class, args);
    }
}
