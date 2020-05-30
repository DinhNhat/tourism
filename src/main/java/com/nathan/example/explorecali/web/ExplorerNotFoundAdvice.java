package com.nathan.example.explorecali.web;

import com.nathan.example.explorecali.busniess.service.ExplorerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExplorerNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ExplorerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String explorerNotFoundHandler(ExplorerNotFoundException ex) {
        return ex.getMessage();
    }
}
