package com.example.project.controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.StudentRepository;


import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository repository;
    @GetMapping("/students")
    /**public List<Student> getAllStudents(){
        return StudentRepository.getAll();
    }*/
    public List<Student> findAll(){
        return repository.findAll();
    }

    @PostMapping("/students")
    public List<Student> insert(){}

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable Long id){

        return null;
    }
}