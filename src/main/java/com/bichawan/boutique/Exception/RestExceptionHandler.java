package com.bichawan.boutique.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(Exception ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrorMessage(ex.getMessage());

        return  new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
