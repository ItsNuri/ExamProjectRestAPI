package com.example.examprojectrestapi.repositories;

import com.example.examprojectrestapi.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {


}
