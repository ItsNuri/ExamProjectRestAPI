package com.example.examprojectrestapi.repositories;

import com.example.examprojectrestapi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}