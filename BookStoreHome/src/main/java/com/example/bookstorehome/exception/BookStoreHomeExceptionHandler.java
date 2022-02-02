package com.example.bookstorehome.exception;

import com.example.bookstorehome.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice : Exception Handler Class
 * @ExceptionHandler : Exception Handler method
 */
@ControllerAdvice
public class BookStoreHomeExceptionHandler {
    private static final String message = " Exception while processing REST Request";
    /**
     * Exception Handler BookStoreEXception
     * @param bookStoreException
     * @return : ResponseEntity of Exception
     */
    @ExceptionHandler(BookStoreHomeException.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(BookStoreHomeException bookStoreException){
        ResponseDTO responseDTO = new ResponseDTO(message,bookStoreException.getMessage(), HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
