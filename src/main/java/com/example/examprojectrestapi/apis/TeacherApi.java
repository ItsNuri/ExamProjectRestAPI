package com.example.examprojectrestapi.apis;

import com.example.examprojectrestapi.dto.teacher.TeacherRequest;
import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.dto.teacher.TeacherResponse;
import com.example.examprojectrestapi.models.Teacher;
import com.example.examprojectrestapi.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherApi {

    private final TeacherService teacherService;

    //find all
    @GetMapping
    public List<TeacherResponse> findAll() {
        return teacherService.findAll();
    }

    //find by id
    @PostMapping("/find/{teacherId}")
    public TeacherResponse findById(@PathVariable Long teacherId) {
        return teacherService.findById(teacherId);
    }

  //  save
    @PostMapping
    public TeacherResponse save(@RequestBody TeacherRequest teacherSaveRequest) {
        return teacherService.save(teacherSaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{teacherId}")
    public SimpleResponse deleteTeacherById(@PathVariable Long teacherId) {
        return teacherService.deleteById(teacherId);
    }

    //update
    @PutMapping("/update/{teacherId}")
    public TeacherResponse updateStudentById(@PathVariable Long teacherId,
                                     @RequestBody TeacherRequest teacherSaveRequest) {
        return teacherService.updateById(teacherId, teacherSaveRequest);
    }

}
