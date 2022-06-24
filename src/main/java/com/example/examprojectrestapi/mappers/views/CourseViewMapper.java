package com.example.examprojectrestapi.mappers.views;

import com.example.examprojectrestapi.dto.course.CourseResponse;
import com.example.examprojectrestapi.models.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course) {
        if(course == null) {
            return null;
        }

        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCourseName(course.getCourseName());
        response.setDuration(course.getDuration());
        response.setCompany(course.getCompany());
        response.setGroups(course.getGroups());
        response.setCreatedDate(course.getCreatedDate());
        response.setActive(course.isActive());
        return response;
    }

    public List<CourseResponse> view(List<Course> courses) {
        List<CourseResponse> responses = new ArrayList<>();
        for (Course course : courses) {
            responses.add(viewCourse(course));
        }
        return responses;
    }
}
