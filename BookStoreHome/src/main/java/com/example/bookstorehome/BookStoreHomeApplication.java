package com.example.bookstorehome;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class BookStoreHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreHomeApplication.class, args);
    }

}
