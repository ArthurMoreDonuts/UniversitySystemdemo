package com.example.UniversitySystemdemo.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {

    @Id
    @GeneratedValue
    private long courseId;
    private String title;
    private int classSize;
    private int waitListSize;
    private String days;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Course(String title, int classSize, int waitListSize, String days) {
        this.title = title;
        this.classSize = classSize;
        this.waitListSize = waitListSize;
        this.days = days;
    }
}
