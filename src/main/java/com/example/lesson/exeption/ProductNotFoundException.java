package com.example.lesson.exeption;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {}

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
