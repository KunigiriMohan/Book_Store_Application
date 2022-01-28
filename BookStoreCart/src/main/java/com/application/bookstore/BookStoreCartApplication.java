package com.application.bookstore;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class BookStoreCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreCartApplication.class, args);
    }

}
