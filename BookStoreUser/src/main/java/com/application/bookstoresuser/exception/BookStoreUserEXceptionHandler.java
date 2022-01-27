package com.application.bookstoresuser.exception;

import com.application.bookstoresuser.dto.ResponseDTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BookStoreUserEXceptionHandler {
    private static final String message = " Exception while processing REST Request";


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message, errMsg, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @ExceptionHandler(BookStoreException.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(BookStoreException bookStoreException){
        ResponseDTO responseDTO = new ResponseDTO(message,bookStoreException.getMessage(),HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ResponseDTO> missingRequestHeaderException(MissingRequestHeaderException exception){
        ResponseDTO responseDTO = new ResponseDTO(message ,"Enter your Token",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
    /*@ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ResponseDTO> handlerEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException) {
        ResponseDTO responseDTO = new ResponseDTO(message, emptyResultDataAccessException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }*/
}
