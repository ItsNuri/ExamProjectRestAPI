package com.example.examprojectrestapi.dto.student;

import com.example.examprojectrestapi.enums.StudyFormat;
import com.example.examprojectrestapi.models.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private StudyFormat studyFormat;

    @JsonIgnore
    private Group group;

    private LocalDate createdDate;

    private boolean isActive;


}
