package com.example.examprojectrestapi.mappers.edits;

import com.example.examprojectrestapi.dto.student.StudentRequest;
import com.example.examprojectrestapi.models.Role;
import com.example.examprojectrestapi.models.Student;
import com.example.examprojectrestapi.models.User;
import com.example.examprojectrestapi.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class StudentEditMapper {
    private final RoleRepository roleRepository;

    public Student create(StudentRequest request) {

        if(request == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(roleRepository.findById(2L).get());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroup(request.getGroup());
        student.setCreatedDate(LocalDate.now());
        student.setUser(user);
        student.setActive(true);
        return student;
    }

    public void update(Student student, StudentRequest request) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.getUser().setEmail(request.getEmail());
        student.getUser().setPassword(request.getPassword());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroup(request.getGroup());
    }
}
