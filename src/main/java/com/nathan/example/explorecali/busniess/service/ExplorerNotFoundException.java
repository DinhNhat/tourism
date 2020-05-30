package com.nathan.example.explorecali.busniess.service;

public class ExplorerNotFoundException extends RuntimeException {
    public ExplorerNotFoundException(int id) {
        super("Could not find explorer " + id);
    }
}
