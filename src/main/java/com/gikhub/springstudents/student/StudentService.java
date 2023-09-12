package com.gikhub.springstudents.student;

import java.util.List;

public interface StudentService {

    Student save(Student newStudent);
    List<Student> findAllStudents();
    Student findByEmail(String email);
    Student update(Student s);
    void delete(String email);
}
