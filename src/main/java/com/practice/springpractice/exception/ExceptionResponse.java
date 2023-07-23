package com.practice.springpractice.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExceptionResponse {
    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}