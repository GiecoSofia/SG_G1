package com.SG_G1.BootcampDH.exception;

import com.SG_G1.BootcampDH.dto.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalHandler {

    // Validacion de Parametros
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> handlerRuntime(RuntimeException exception){
        List<String> miLista = Arrays.asList(exception.getMessage());
        ErrorDTO hola = new ErrorDTO();
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones: ",
                        miLista)
        );
    }

    // Validacion de Jason
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handlerRuntime(HttpMessageNotReadableException exception){
        return new ResponseEntity<>("El json no esta mandodado de manera corrrecta", HttpStatus.BAD_REQUEST);
    }

    // Validacion de Array vacio (base de datos futuro)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerRuntime1(NullPointerException exception){
        return new ResponseEntity<>("Es un array vacio", HttpStatus.NOT_FOUND);
    }


    // Validacion de Parametros (DatetimeFormat)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> handlerRuntime2(MethodArgumentTypeMismatchException exception){
        //return new ResponseEntity<>("La formato de la fecha es invalido, dd/MM/yyyy", HttpStatus.NOT_FOUND);
        List<String> miLista = Arrays.asList("La formato de la fecha es invalido, dd/MM/yyyy");
        ErrorDTO hola = new ErrorDTO();
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones: ",
                        miLista)
        );

    }
    // Validaciones de los DTO
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validationException(ConstraintViolationException e){
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones: ",
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );
    }



}
