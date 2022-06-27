package com.example.examprojectrestapi.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_id_generator"
    )
    @SequenceGenerator(
            name = "group_id_generator",
            sequenceName = "group_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "date_of_start", nullable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfStart;

    @Column(name = "date_of_finish", nullable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfFinish;

    @ManyToMany(cascade = {DETACH,MERGE})
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "group",cascade = {ALL})
    private List<Student> students = new ArrayList<>();

    @CreatedDate
    private LocalDate createdDate;

    private boolean isActive;

    @OneToOne
    private User user;

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }


}
