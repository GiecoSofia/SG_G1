package com.SG_G1.BootcampDH.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRuntime(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handlerRuntime(HttpMessageNotReadableException exception){
        return new ResponseEntity<>("El json no esta mandodado de manera corrrecta", HttpStatus.BAD_REQUEST);
    }
    /*
    @ExceptionHandler(SinBlogsException.class)
    public ResponseEntity<String> handlerRuntime(SinBlogsException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }*/
}
