package com.gikhub.springstudents.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Student  save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return service.update(student);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        service.delete(email);
    }
}
