package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    public String message;
    public Object data;
    public HttpStatus httpStatus;
}
