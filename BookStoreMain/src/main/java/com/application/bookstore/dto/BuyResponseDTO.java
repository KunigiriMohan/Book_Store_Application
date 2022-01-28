package com.application.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyResponseDTO {
    public String message;
    public Object data;
    private Long value;
    public HttpStatus httpStatus;

}
