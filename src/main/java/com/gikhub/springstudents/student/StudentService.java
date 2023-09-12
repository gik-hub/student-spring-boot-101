package com.gikhub.springstudents.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> findAllStudents() {
        return List.of(
                new Student("Liam", "Taji", LocalDate.now(), "liam@gmail.com"),
                new Student("Linda G", "Talia", LocalDate.now(), "linda@gmail.com")
        );
    }
}
