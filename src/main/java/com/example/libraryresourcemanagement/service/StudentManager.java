package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Student;
import com.example.libraryresourcemanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    @Autowired
    StudentRepository repository;


    @Override
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found with id " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student updated) {
        Student student = getStudentById(id);
        student.setFullName(updated.getFullName());
        student.setEmail(updated.getEmail());
        student.setPhoneNumber(updated.getPhoneNumber());
        student.setAddress(updated.getAddress());
        student.setLibrarian(updated.getLibrarian());
        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public void addStudent(Student student) {
//        repository.addStudent(student);
//    }
}

