package com.example.bookstoreconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BookStoreConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreConfigServerApplication.class, args);
    }

}
