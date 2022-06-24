package com.example.examprojectrestapi.exceptions;

import java.text.MessageFormat;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException() {
        super();
    }

    public GroupNotFoundException(Long id) {
        super(MessageFormat.format("Could not find group with id: {id}",id));
    }
}
