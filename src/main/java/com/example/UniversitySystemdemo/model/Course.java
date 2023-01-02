package com.example.UniversitySystemdemo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    long courseId;
    String title;
    int classSize;
    int waitListSize;
    String days;

    public Course(String title, int classSize, int waitListSize, String days) {
        this.title = title;
        this.classSize = classSize;
        this.waitListSize = waitListSize;
        this.days = days;
    }
}
