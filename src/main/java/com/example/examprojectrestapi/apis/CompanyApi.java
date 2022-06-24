package com.example.examprojectrestapi.apis;

import com.example.examprojectrestapi.dto.company.CompanyRequest;
import com.example.examprojectrestapi.dto.company.CompanyResponse;
import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin
@RequiredArgsConstructor

public class CompanyApi {
    private final CompanyService companyService;

    //find all
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CompanyResponse> findAll() {
        return companyService.findAll();
    }

    //find by id
    @GetMapping("/find{companyId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public CompanyResponse findById(@PathVariable Long companyId) {
        return companyService.findById(companyId);
    }

    //save
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public CompanyResponse save(@RequestBody CompanyRequest companySaveRequest) {
        return companyService.save(companySaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{companyId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SimpleResponse deleteCompanyById(@PathVariable Long companyId) {
        return companyService.deleteById(companyId);
    }

    //update
    @PutMapping("/update/{companyId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public CompanyResponse updateCompanyById(@PathVariable Long companyId,
                                     @RequestBody CompanyRequest companySaveRequest) {
        return companyService.updateCompanyById(companyId, companySaveRequest);
    }


}
