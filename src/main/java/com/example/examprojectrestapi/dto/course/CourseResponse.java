package com.example.examprojectrestapi.dto.course;

import com.example.examprojectrestapi.models.Company;
import com.example.examprojectrestapi.models.Group;
import com.example.examprojectrestapi.models.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CourseResponse {

    private Long id;

    private String courseName;

    private int duration;

    @JsonIgnore
    private Company company;

    @JsonIgnore
    private List<Group> groups = new ArrayList<>();

    @JsonIgnore
    private Teacher teacher;

    private LocalDate createdDate;

    private boolean isActive;

}
