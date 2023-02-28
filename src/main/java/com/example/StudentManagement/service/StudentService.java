package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);
}
