package com.jefr.RandomRiftRoulette.presentation.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseStatusException dtoNotReadable() {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid input");
    }
}
