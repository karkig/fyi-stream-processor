package com.practice.springpractice.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Integer id) {
        super(String.format("Resource with Id %d not found", id));
    }
}