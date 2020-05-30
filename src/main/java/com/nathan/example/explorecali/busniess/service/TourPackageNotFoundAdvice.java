package com.nathan.example.explorecali.busniess.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TourPackageNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TourPackageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tourpackageNotFoundHandler(TourPackageNotFoundException ex) {
        return ex.getMessage();
    }
}
