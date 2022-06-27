package com.example.examprojectrestapi.services;

import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.dto.student.StudentRequest;
import com.example.examprojectrestapi.dto.student.StudentResponse;
import com.example.examprojectrestapi.exceptions.StudentNotFoundException;
import com.example.examprojectrestapi.mappers.edits.StudentEditMapper;
import com.example.examprojectrestapi.mappers.views.StudentViewMapper;
import com.example.examprojectrestapi.models.Student;
import com.example.examprojectrestapi.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentViewMapper studentViewMapper;
    private final StudentEditMapper studentEditMapper;

//    private Student getStudentById(Long studentId) {
//        return studentRepository.findById(studentId).orElseThrow(
//                () -> new StudentNotFoundException(studentId)
//        );
//    }

    //find all
    public List<StudentResponse> findAll() {
        return studentViewMapper.view(studentRepository.findAll());
    }

    //find by id
    public StudentResponse findById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException("My Exception: Couldn't not fount student!")
        );
        return studentViewMapper.viewStudent(student);
    }

    //save
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = studentEditMapper.create(studentRequest);
        studentRepository.save(student);
        return studentViewMapper.viewStudent(student);
    }

    //delete by id
    public SimpleResponse deleteById(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new StudentNotFoundException("My Exception: Couldn't not fount student!");
        }
        studentRepository.deleteById(studentId);

        return new SimpleResponse(
                "DELETED",
                "Successfully deleted student!"
        );
    }

    //update by id
    public StudentResponse updateById(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentId).get();
        studentEditMapper.update(student, studentRequest);
        studentRepository.save(student);
        return studentViewMapper.viewStudent(studentRepository.save(student));
    }
}
