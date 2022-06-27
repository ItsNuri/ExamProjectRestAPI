package com.example.examprojectrestapi.mappers.views;

import com.example.examprojectrestapi.dto.student.StudentResponse;
import com.example.examprojectrestapi.models.Student;
import com.example.examprojectrestapi.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getUser().getEmail());
        response.setStudyFormat(student.getStudyFormat());
        response.setGroup(student.getGroup());
        response.setCreatedDate(student.getCreatedDate());
        response.setActive(student.isActive());
        return response;
    }

    public List<StudentResponse> view(List<Student> students) {
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students) {
            responses.add(viewStudent(student));
        }
        return responses;
    }
}
