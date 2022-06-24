package com.example.examprojectrestapi.apis;

import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.dto.course.CourseRequest;
import com.example.examprojectrestapi.dto.course.CourseResponse;
import com.example.examprojectrestapi.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;

    //find all
    @GetMapping
    public List<CourseResponse> findAll() {
        return courseService.findAll();
    }

    //find by id
    @GetMapping("/find/{courseId}")
    public CourseResponse findById(@PathVariable Long courseId) {
        return courseService.findById(courseId);
    }

    //save
    @PostMapping
    public CourseResponse save(@RequestBody CourseRequest courseSaveRequest) {
        return courseService.save(courseSaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{courseId}")
    public SimpleResponse deleteCourseById(@PathVariable Long courseId) {
        return courseService.deleteById(courseId);
    }

    //update
    @PutMapping("/update/{courseId}")
    public CourseResponse updateCourseById(@PathVariable Long courseId,
                                   @RequestBody CourseRequest courseSaveRequest) {
        return courseService.updateCourseById(courseId, courseSaveRequest);
    }

}
