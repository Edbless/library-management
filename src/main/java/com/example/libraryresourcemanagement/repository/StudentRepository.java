package com.example.libraryresourcemanagement.repository;


import com.example.libraryresourcemanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    void addStudent(Student student);
}

