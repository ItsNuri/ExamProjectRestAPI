package com.example.examprojectrestapi.mappers.edits;

import com.example.examprojectrestapi.dto.company.CompanyRequest;
import com.example.examprojectrestapi.models.Company;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompanyEditMapper {

    public Company create(CompanyRequest request) {

        if(request == null) {
            return null;
        }

        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setLocatedCountry(request.getLocatedCountry());
        company.setCreatedDate(LocalDate.now());
        company.setActive(true);

        return company;
    }

    public void update(Company company, CompanyRequest request) {
        company.setCompanyName(request.getCompanyName());
        company.setLocatedCountry(request.getLocatedCountry());
    }
}
