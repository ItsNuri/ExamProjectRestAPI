package com.example.examprojectrestapi.dto.course;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

    private String courseName;

    private int duration;
}
