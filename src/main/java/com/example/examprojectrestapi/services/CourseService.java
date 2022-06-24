package com.example.examprojectrestapi.services;

import com.example.examprojectrestapi.dto.course.CourseRequest;
import com.example.examprojectrestapi.dto.course.CourseResponse;
import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.exceptions.CourseNotFoundException;
import com.example.examprojectrestapi.mappers.edits.CourseEditMapper;
import com.example.examprojectrestapi.mappers.views.CourseViewMapper;
import com.example.examprojectrestapi.models.Course;
import com.example.examprojectrestapi.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    private final CourseEditMapper courseEditMapper;

    private final CourseViewMapper courseViewMapper;

    private Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(
                () -> new CourseNotFoundException(courseId)
        );
    }

    //find all
    public List<CourseResponse> findAll() {
        return courseViewMapper.view(courseRepository.findAll());
    }

    //find by id
    public CourseResponse findById(Long courseId) {
        Course course = getCourseById(courseId);
        return courseViewMapper.viewCourse(course);
    }

    //save
    public CourseResponse save(CourseRequest courseRequest) {
        Course course = courseEditMapper.create(courseRequest);
        courseRepository.save(course);
        return courseViewMapper.viewCourse(course);
        }

    //delete by id
    public SimpleResponse deleteById(Long courseId) {
        boolean exists = courseRepository.existsById(courseId);

        if (!exists) {
            throw new CourseNotFoundException(courseId);
        }
        courseRepository.deleteById(courseId);

        return new SimpleResponse(
                "DELETED",
                "Successfully delete company!"
        );
    }

    //update by id
    public CourseResponse updateCourseById(Long courseId, CourseRequest courseRequest) {
        Course course = getCourseById(courseId);
        courseEditMapper.update(course,courseRequest);
        courseRepository.save(course);
        return courseViewMapper.viewCourse(courseRepository.save(course));
    }


}
