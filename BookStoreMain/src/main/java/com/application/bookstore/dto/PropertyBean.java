package com.application.bookstore.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@ConfigurationProperties("book-store-service")
public class PropertyBean {
    private String signupURL;
    private String loginURL;
    private String deleteUserByIdURL;
    private String updateUserByIdURl;
    private String getallbooksURL;
    private String getallbookByIDURL;
    private String addBookToCartURL;
    private String getAllBookinCart;
    private String removeBookFromCart;
    private String buyNowBookURL;
    private String buyNowBookFromCart;
    private String updateUserDetailsByIDURL;

}
