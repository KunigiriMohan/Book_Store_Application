package com.application.bookstoresuser;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication : Spring Boot Main Applicataion
 */
@EnableEncryptableProperties
@SpringBootApplication
public class BookStoreUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreUserApplication.class, args);
	}

}
