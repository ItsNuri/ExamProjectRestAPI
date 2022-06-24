package com.example.examprojectrestapi.dto.teacher;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeacherRequest {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate createDate;

    private boolean isActive;

}
