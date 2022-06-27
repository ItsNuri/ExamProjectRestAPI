package com.example.examprojectrestapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(String message) {
        super(message);
    }
}
