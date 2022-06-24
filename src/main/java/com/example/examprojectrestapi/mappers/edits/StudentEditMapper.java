package com.example.examprojectrestapi.mappers.edits;

import com.example.examprojectrestapi.dto.student.StudentRequest;
import com.example.examprojectrestapi.models.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentEditMapper {

    public Student create(StudentRequest request) {

        if(request == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroup(request.getGroup());
        student.setCreatedDate(LocalDate.now());
        student.setActive(true);

        return student;
    }

    public void update(Student student, StudentRequest request) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroup(request.getGroup());
    }
}
