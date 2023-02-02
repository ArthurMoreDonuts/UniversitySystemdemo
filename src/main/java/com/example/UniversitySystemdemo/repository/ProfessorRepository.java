package com.example.UniversitySystemdemo.repository;

import com.example.UniversitySystemdemo.model.Course;
import com.example.UniversitySystemdemo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
