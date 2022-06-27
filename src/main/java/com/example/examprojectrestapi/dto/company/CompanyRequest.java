package com.example.examprojectrestapi.dto.company;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyRequest {


    private String companyName;
    private String locatedCountry;
    private LocalDate created;
    private boolean isActive;

}
