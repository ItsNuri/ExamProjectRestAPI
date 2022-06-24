package com.example.examprojectrestapi.exceptions;

import java.text.MessageFormat;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
    }

    public StudentNotFoundException(Long id) {
        super(MessageFormat.format("Could not find student with id: {id}",id));
    }
}
