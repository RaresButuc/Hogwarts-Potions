package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.interfaces.StudentsRepository;
import com.codecool.hogwarts_potions.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
    public List<Student> getAllStudent() {
        return studentsRepository.findAll();
    }

    public void postANewStudent(Student student) {
        studentsRepository.save(student);
    }
}
