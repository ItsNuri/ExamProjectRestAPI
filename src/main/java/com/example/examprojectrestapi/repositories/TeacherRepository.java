package com.example.examprojectrestapi.repositories;

import com.example.examprojectrestapi.dto.teacher.TeacherResponse;
import com.example.examprojectrestapi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
