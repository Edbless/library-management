package com.example.libraryresourcemanagement.controller;

import com.example.libraryresourcemanagement.service.StudentManager;
import com.example.libraryresourcemanagement.service.BookManager;
import com.example.libraryresourcemanagement.service.AuthorManager;
import com.example.libraryresourcemanagement.service.BorrowingManager;
import com.example.libraryresourcemanagement.service.LibrarianManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class DashboardController {

    @Autowired
    private StudentManager studentManager;

    @Autowired
    private BookManager bookManager;

    @Autowired
    private AuthorManager authorManager;

    @Autowired
    private BorrowingManager borrowingManager;

    @Autowired
    private LibrarianManager librarianManager;

    @RequestMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("studentCount", studentManager.getAllStudents().size());
        model.addAttribute("bookCount", bookManager.getAllBooks().size());
        model.addAttribute("authorCount", authorManager.getAllAuthors().size());
        model.addAttribute("borrowingCount", borrowingManager.getAllBorrowings().size());
        model.addAttribute("librarianCount", librarianManager.getAllLibrarians().size());
        return "dashboard/main";
    }
}
