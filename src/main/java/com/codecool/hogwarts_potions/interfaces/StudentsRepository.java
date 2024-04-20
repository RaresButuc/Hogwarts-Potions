package com.codecool.hogwarts_potions.interfaces;

import com.codecool.hogwarts_potions.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
