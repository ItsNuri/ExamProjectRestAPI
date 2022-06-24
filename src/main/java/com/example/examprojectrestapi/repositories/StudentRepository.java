package com.example.examprojectrestapi.repositories;

import com.example.examprojectrestapi.dto.student.StudentResponse;
import com.example.examprojectrestapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
