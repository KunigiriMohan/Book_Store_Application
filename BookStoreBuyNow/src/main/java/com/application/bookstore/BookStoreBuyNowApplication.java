package com.application.bookstore;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class BookStoreBuyNowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreBuyNowApplication.class, args);
    }

}
