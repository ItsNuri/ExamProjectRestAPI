package com.example.examprojectrestapi.mappers.edits;

import com.example.examprojectrestapi.dto.teacher.TeacherRequest;
import com.example.examprojectrestapi.models.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherEditMapper {

    public Teacher create(TeacherRequest request) {

        if(request == null) {
            return null;
        }

        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setCreatedDate(request.getCreateDate());
        teacher.setActive(request.isActive());
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest request) {
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
    }
}
