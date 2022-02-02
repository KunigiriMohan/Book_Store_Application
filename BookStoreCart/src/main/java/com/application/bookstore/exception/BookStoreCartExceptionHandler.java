package com.application.bookstore.exception;

import com.application.bookstore.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ControllerAdvice : Creating Controller Advice to Handle Exceptions
 * @ExceptionHandler : Creating Exception Handler method to handle Exceptions Thrown
 */
@ControllerAdvice
public class BookStoreCartExceptionHandler {
    private static final String message = " Exception while processing REST Request";


    /**
     * Exception Handler for MethodArgumentNotValidException
     * @param methodArgumentNotValidException
     * @return : ResponseEntity of Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message, errMsg, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    /**
     * Exception Handler BookStoreEXception
     * @param bookStoreException
     * @return : ResponseEntity of Exception
     */
    @ExceptionHandler(BookStoreException.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(BookStoreException bookStoreException){
        ResponseDTO responseDTO = new ResponseDTO(message,bookStoreException.getMessage(),HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Exception Handler MissingRequestHeaderException
     * @param exception
     * @return : REsponseEntity of Exception
     */
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ResponseDTO> missingRequestHeaderException(MissingRequestHeaderException exception){
        ResponseDTO responseDTO = new ResponseDTO(message ,"Enter your Token",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception Handler UserException
     * @param exception
     * @return : REsponseEntity of Exception
     */
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(UserException userException){
        ResponseDTO responseDTO = new ResponseDTO(message,userException.getMessage(),HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
