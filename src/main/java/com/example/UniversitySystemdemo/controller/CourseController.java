package com.example.UniversitySystemdemo.controller;

import com.example.UniversitySystemdemo.model.Course;
import com.example.UniversitySystemdemo.model.Professor;
import com.example.UniversitySystemdemo.repository.CourseRepository;
import com.example.UniversitySystemdemo.repository.ProfessorRepository;
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
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping("/Course")
    public ResponseEntity<Course> getCourse(){
      courseRepository.save( new Course("Programming",25,5,"UTR"));
        return new ResponseEntity<>(
                new Course("Programming",25,5,"UTR"),
                HttpStatus.OK);
    }

    @GetMapping("/Course-list")
    public ResponseEntity<ArrayList<Course>> getCourses(){

        return new ResponseEntity<>(
                (ArrayList<Course>) courseRepository.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/Course-add")
    public Course AddProfessorToCourse(){
        Course course = courseRepository.findAll().get(1);
        course.setProfessor(new Professor("Issam Louhichi","Math"));
        professorRepository.save(course.getProfessor());
        return course;
    }

    @GetMapping("/Course-string")
    public String getCourseString(){
        return "We couldn't return the object ";
    }

    @GetMapping("/reset_courses")
    public ResponseEntity<String> reset(){
        courseRepository.deleteAll();
        return new ResponseEntity<>(
                HttpStatus.OK);
    }


}
