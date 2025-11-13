package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);

    void editStudent(Student student);

//    void addStudent(Student student);
}

