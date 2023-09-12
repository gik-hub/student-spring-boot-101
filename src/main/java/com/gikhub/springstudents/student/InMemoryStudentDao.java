package com.gikhub.springstudents.student;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDao {

    private final List<Student> STUDENTS = new ArrayList<>();

    public Student save(Student newStudent) {
        STUDENTS.add(newStudent);
        return newStudent;
    }

    public List<Student> findAllStudents() {
        return STUDENTS;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(student -> email.equals(student.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public Student update(Student studentUpdate) {
        var studentIdx = IntStream.range(0, STUDENTS.size())
                .filter(idx -> STUDENTS.get(idx).getEmail().equals(studentUpdate.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIdx > -1) {
            STUDENTS.set(studentIdx, studentUpdate);
            return studentUpdate;
        }
        return null;
    }

    public void delete(String email) {
        var student = findByEmail(email);
        if(student != null) {
            STUDENTS.remove(student);
        }

    }
}
