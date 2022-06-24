package com.example.examprojectrestapi.exceptions;

import java.text.MessageFormat;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException() {
    }

    public TeacherNotFoundException(Long id) {
        super(MessageFormat.format("Could not find teacher with id: {id}",id));
    }
}
