package com.example.examprojectrestapi.mappers.views;

import com.example.examprojectrestapi.dto.teacher.TeacherResponse;
import com.example.examprojectrestapi.models.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewCompany(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherResponse response = new TeacherResponse();
        response.setId(teacher.getId());
        response.setFirstName(teacher.getFirstName());
        response.setLastName(teacher.getLastName());
        response.setEmail(teacher.getEmail());
        response.setCourse(teacher.getCourse());
        response.setCreatedDate(teacher.getCreatedDate());
        response.setActive(teacher.isActive());
        return response;
    }

    public List<TeacherResponse> view(List<Teacher> teachers) {
        List<TeacherResponse> responses = new ArrayList<>();
        for (Teacher teacher : teachers) {
            responses.add(viewCompany(teacher));
        }
        return responses;
    }
}
