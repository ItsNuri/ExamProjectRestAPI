package com.example.examprojectrestapi.exceptions;

import java.text.MessageFormat;

public class CompanyNotFoundException extends RuntimeException{

    public CompanyNotFoundException() {
        super();
    }

    public CompanyNotFoundException(Long id) {
        super(MessageFormat.format("Could not find company with id: {id}", id));
    }
}
