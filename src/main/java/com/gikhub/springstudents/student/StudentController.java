package com.gikhub.springstudents.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
//    @Autowired // Field injection
    private StudentService service;

//    @Autowired // Constructor injection - not a must - spring can automatically inject it
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }
}
