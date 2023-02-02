package com.example.UniversitySystemdemo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Professor {

    @Id
    @GeneratedValue
    private long professorId;

    private String name;
    private String department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    private List<Course> coursesTeaching;

    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void addCourse(Course course){
        coursesTeaching.add(course);
        course.setProfessor(this);
    }
}
