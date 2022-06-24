package com.example.examprojectrestapi.mappers.edits;

import com.example.examprojectrestapi.dto.course.CourseRequest;
import com.example.examprojectrestapi.models.Course;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CourseEditMapper {

    public Course create(CourseRequest request) {

        if(request == null) {
            return null;
        }

        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        course.setCreatedDate(LocalDate.now());
        course.setActive(true);

        return course;
    }

    public void update(Course course, CourseRequest request) {
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
    }
}
