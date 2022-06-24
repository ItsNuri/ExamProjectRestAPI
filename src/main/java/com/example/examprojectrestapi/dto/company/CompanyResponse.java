package com.example.examprojectrestapi.dto.company;

import com.example.examprojectrestapi.models.Company;
import com.example.examprojectrestapi.models.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

    private Long id;

    private String companyName;

    private String locatedCountry;

    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    private LocalDate createdDate;

    private Boolean isActive;


}
