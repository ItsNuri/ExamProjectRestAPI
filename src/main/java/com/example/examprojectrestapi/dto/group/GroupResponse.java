package com.example.examprojectrestapi.dto.group;

import com.example.examprojectrestapi.models.Course;
import com.example.examprojectrestapi.models.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GroupResponse {

    private Long id;

    private String groupName;

    private Date dateOfStart;

    private Date dateOfFinish;

    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    private LocalDate createdDate;

    private boolean isActive;


}
