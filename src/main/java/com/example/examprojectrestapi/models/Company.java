package com.example.examprojectrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "companies")
@Setter
@Getter
public class Company {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_id_generator"
    )
    @SequenceGenerator(
            name = "company_id_generator",
            sequenceName = "company_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "located_county")
    private String locatedCountry;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = ALL)
    private List<Course> courses = new ArrayList<>();

    @CreatedDate
    private LocalDate createdDate;

    private boolean isActive;

    @OneToOne
    private User user;

    public void setCourse(Course course) {
        this.courses.add(course);
    }

}
