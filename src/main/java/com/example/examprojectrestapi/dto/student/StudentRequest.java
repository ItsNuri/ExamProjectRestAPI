package com.example.examprojectrestapi.dto.student;

import com.example.examprojectrestapi.enums.StudyFormat;
import com.example.examprojectrestapi.models.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentRequest {

    private String firstName;

    private String lastName;

    private String email;

    private StudyFormat studyFormat;

    @JsonIgnore
    private Group group;

    private String password;

}
