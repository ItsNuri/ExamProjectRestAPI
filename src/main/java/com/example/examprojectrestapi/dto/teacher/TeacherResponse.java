package com.example.examprojectrestapi.dto.teacher;

import com.example.examprojectrestapi.dto.course.CourseResponse;
import com.example.examprojectrestapi.models.Course;
import com.example.examprojectrestapi.models.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeacherResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate createdDate;

    private boolean isActive;

    @JsonIgnore
    private Course course;


}
