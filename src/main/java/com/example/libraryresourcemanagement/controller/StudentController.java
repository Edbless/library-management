package com.example.libraryresourcemanagement.controller;

import com.example.libraryresourcemanagement.entity.Student;
import com.example.libraryresourcemanagement.service.LibrarianManager;
import com.example.libraryresourcemanagement.service.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private LibrarianManager librarianManager;

    @Autowired
    private StudentManager studentManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("students", studentManager.getAllStudents());
        return "students/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("librarians", librarianManager.getAllLibrarians());
        return "students/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute Student student) {
        studentManager.saveStudent(student);
        return "redirect:/students/list";
    }

    // GET mapping to show the edit form
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Student student = studentManager.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("librarians", librarianManager.getAllLibrarians());
        return "students/form";
    }

    // POST mapping to save edited student
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editStudent(@ModelAttribute Student student) {
        studentManager.editStudent(student);
        return "redirect:/students/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam Long id) {
        studentManager.deleteStudent(id);
        return "redirect:/students/list";
    }
}
