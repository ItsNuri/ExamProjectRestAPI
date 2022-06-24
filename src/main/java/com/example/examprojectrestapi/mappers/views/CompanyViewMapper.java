package com.example.examprojectrestapi.mappers.views;

import com.example.examprojectrestapi.dto.company.CompanyResponse;
import com.example.examprojectrestapi.models.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }

        CompanyResponse response = new CompanyResponse();
        response.setId(company.getId());
        response.setCompanyName(company.getCompanyName());
        response.setLocatedCountry(company.getLocatedCountry());
        response.setCourses(company.getCourses());
        response.setCreatedDate(company.getCreatedDate());
        response.setIsActive(company.isActive());

        return response;
    }

    public List<CompanyResponse> view(List<Company> companies) {
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company company : companies) {
            responses.add(viewCompany(company));
        }
        return responses;
    }




}
