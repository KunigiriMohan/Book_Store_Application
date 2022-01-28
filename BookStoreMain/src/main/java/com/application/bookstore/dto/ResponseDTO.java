package com.application.bookstore.dto;

import com.application.bookstore.model.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    public String message;
    public Object data;
    public HttpStatus httpStatus;

    public ResponseDTO(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResponseDTO(Object bookinCart, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.data = bookinCart;
    }
}
