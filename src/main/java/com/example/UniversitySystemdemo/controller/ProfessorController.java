package com.example.UniversitySystemdemo.controller;

import com.example.UniversitySystemdemo.model.Course;
import com.example.UniversitySystemdemo.model.Professor;
import com.example.UniversitySystemdemo.repository.CourseRepository;
import com.example.UniversitySystemdemo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/Api")
@RestController
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/Professor")
    public ResponseEntity<Professor> getProfessor(){
      professorRepository.save( new Professor("Issam Louhichi","Math"));
        List<Professor> all = professorRepository.findAll();
        return new ResponseEntity<>(
                all.get(all.size()-1),
                HttpStatus.OK);
    }

    @GetMapping("/Professors")
    public ResponseEntity<List<Professor>> getProfessorList(){
        return new ResponseEntity<>(
                 professorRepository.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/Professors/{id}")
    public ResponseEntity<Professor> getProfessorLById(@PathVariable String id){
        Optional<Professor> professor = professorRepository.findById(Long.parseLong(id));
        if(professor.isPresent())
            return new ResponseEntity<>(
                    professor.get(),
                    HttpStatus.OK);
        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND);

    }

    @GetMapping("/Professors/{id}/courses")
    public ResponseEntity<List<Course>> getProfessorCourses(@PathVariable String id){
        Optional<Professor> professor = professorRepository.findById(Long.parseLong(id));
        return professor.map(value -> new ResponseEntity<>(
                value.getCoursesTeaching(),
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(
                HttpStatus.NOT_FOUND));

    }

    @GetMapping("/Add_Professor")
    public ResponseEntity<List<Professor>> addProfessor(){
        List<Professor> professors = professorRepository.findAll();
      //  Professor professor = professors.get(0);
     //   ArrayList<Course> coursesTeaching = professor.getCoursesTeaching();
     //   coursesTeaching.add(new Course("Programming", 25, 5, "UTR"));
     //   professor.setCoursesTeaching(coursesTeaching);
        return new ResponseEntity<>(
                professors,
                HttpStatus.OK);
    }

    @GetMapping("/reset_professors")
    public ResponseEntity<String> reset(){
        professorRepository.deleteAll();
        return new ResponseEntity<>(
                HttpStatus.OK);
    }

    @GetMapping("/Professors/Add_Course")
    public ResponseEntity<List<Professor>> addCourseToProffesor(){
        Course mycourse = courseRepository.findAll().get(0);

        Professor professor = professorRepository.findAll().get(0);
        professor.addCourse(mycourse);
        //courseRepository.save(mycourse);
        professorRepository.save(professor);
        return new ResponseEntity<>(
                professorRepository.findAll(),
                HttpStatus.OK);
    }

}
