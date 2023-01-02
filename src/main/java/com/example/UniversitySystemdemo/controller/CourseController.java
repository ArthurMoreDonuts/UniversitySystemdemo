package com.example.UniversitySystemdemo.controller;

import com.example.UniversitySystemdemo.model.Course;
import com.example.UniversitySystemdemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/Api")
@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/Course")
    public ResponseEntity<Course> getCourse(){
      courseRepository.save( new Course("Programming",25,5,"UTR"));
        return new ResponseEntity<>(
                new Course(100,"Programming",25,5,"UTR"),
                HttpStatus.OK);
    }

    @GetMapping("/Course-list")
    public ResponseEntity<ArrayList<Course>> getCourses(){

        return new ResponseEntity<ArrayList<Course>>(
                (ArrayList<Course>) courseRepository.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/Course-string")
    public String getCourseString(){
        return "We couldn't return the object ";
    }



}
