package com.nathan.example.explorecali.busniess.service;

public class TourPackageNotFoundException extends RuntimeException {
    public TourPackageNotFoundException(Integer id) {
        super("Could not find TourPackage " + id);
    }
}
