package com.example.examprojectrestapi.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "courses")
@Getter
@Setter
@ToString
public class Course implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id_generator"
    )
    @SequenceGenerator(
            name = "course_id_generator",
            sequenceName = "course_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    private int duration;

    @ManyToOne(cascade = {MERGE,DETACH,REFRESH})
    private Company company;

    @ManyToMany(mappedBy = "courses", cascade = {ALL}, fetch = FetchType.EAGER)
    private List<Group> groups = new ArrayList<>();

    @OneToOne(mappedBy = "course", cascade = ALL)
    private Teacher teacher;

    @CreatedDate
    private LocalDate createdDate;

    private boolean isActive;

    public Course() {
    }

    public Course(Long id,String courseName, int duration, Company company,
                  List<Group> groups, Teacher teacher,
                  LocalDate createdDate, boolean isActive) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.company = company;
        this.groups = groups;
        this.teacher = teacher;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

}
