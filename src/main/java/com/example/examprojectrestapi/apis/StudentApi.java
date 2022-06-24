package com.example.examprojectrestapi.apis;

import com.example.examprojectrestapi.dto.student.StudentRequest;
import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.dto.student.StudentResponse;
import com.example.examprojectrestapi.models.Student;
import com.example.examprojectrestapi.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    //find all
    @GetMapping
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    //find by id
    @PostMapping("/find/{studentId}")
    public StudentResponse findById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }


    //save
    @PostMapping
    public StudentResponse save(@RequestBody StudentRequest studentSaveRequest) {
        return studentService.save(studentSaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{studentId}")
    public SimpleResponse deleteStudentById(@PathVariable Long studentId) {
        return studentService.deleteById(studentId);
    }

    //update
    @PutMapping("/update/{studentId}")
    public StudentResponse updateStudentById(@PathVariable Long studentId,
                                 @RequestBody StudentRequest studentSaveRequest) {
        return studentService.updateById(studentId,studentSaveRequest);
    }
}
