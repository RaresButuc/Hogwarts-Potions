package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.Potion;
import com.codecool.hogwarts_potions.model.Student;
import com.codecool.hogwarts_potions.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> returnAllStudents() {
        return studentService.getAllStudent();
    }

    @PostMapping
    public void postAStudent(@RequestBody Student newStudent) {
        studentService.postANewStudent(newStudent);
    }
}
