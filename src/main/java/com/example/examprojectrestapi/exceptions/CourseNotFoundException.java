package com.example.examprojectrestapi.exceptions;

import java.text.MessageFormat;

public class CourseNotFoundException extends RuntimeException{


    public CourseNotFoundException() {
        super();
    }

    public CourseNotFoundException(Long id) {
        super(MessageFormat.format("Could not find course with id: {id}",id));
    }
}
