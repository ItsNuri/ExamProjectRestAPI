package com.example.examprojectrestapi.services;

import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.dto.company.CompanyRequest;
import com.example.examprojectrestapi.dto.company.CompanyResponse;
import com.example.examprojectrestapi.exceptions.CompanyNotFoundException;
import com.example.examprojectrestapi.mappers.edits.CompanyEditMapper;
import com.example.examprojectrestapi.mappers.views.CompanyViewMapper;
import com.example.examprojectrestapi.models.Company;
import com.example.examprojectrestapi.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyEditMapper companyEditMapper;
    private final CompanyViewMapper companyViewMapper;

    //find all
    public List<CompanyResponse> findAll() {
        return companyViewMapper.view(companyRepository.findAll());
    }

    //findById
    public CompanyResponse findById(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(()->
                new CompanyNotFoundException("My Exception: Couldn't not fount company!")
        );
        return companyViewMapper.viewCompany(company);
    }

    //save
    public CompanyResponse save(CompanyRequest companyRequest) {
        Company company = companyEditMapper.create(companyRequest);
        companyRepository.save(company);
        return companyViewMapper.viewCompany(company);
    }

    //delete
    public SimpleResponse deleteById(Long companyId) {
        boolean exists = companyRepository.existsById(companyId);

        if (!exists) {
            throw new CompanyNotFoundException("My Exception: Couldn't not fount company!");
        }

        companyRepository.deleteById(companyId);

        return new SimpleResponse(
                "DELETED",
                "Successfully delete company!"
        );
    }

//    update
    public CompanyResponse updateCompanyById(Long companyId, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(companyId).get();
        companyEditMapper.update(company,companyRequest);
        companyRepository.save(company);
        return companyViewMapper.viewCompany(companyRepository.save(company));
    }
}

