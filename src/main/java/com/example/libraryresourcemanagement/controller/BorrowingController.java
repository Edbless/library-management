package com.example.libraryresourcemanagement.controller;


import com.example.libraryresourcemanagement.entity.Borrowing;
import com.example.libraryresourcemanagement.service.BookManager;
import com.example.libraryresourcemanagement.service.BorrowingManager;
import com.example.libraryresourcemanagement.service.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingManager borrowingManager;

    @Autowired
    private StudentManager studentManager;

    @Autowired
    private BookManager bookManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBorrowings(Model model) {
        model.addAttribute("borrowings", borrowingManager.getAllBorrowings());
        return "borrowings/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("borrowing", new Borrowing());
        model.addAttribute("students", studentManager.getAllStudents());
        model.addAttribute("books", bookManager.getAllBooks());
        return "borrowings/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBorrowing(@ModelAttribute Borrowing borrowing) {
        borrowingManager.saveBorrowing(borrowing);
        return "redirect:/borrowings/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBorrowing(@RequestParam Long id) {
        borrowingManager.deleteBorrowing(id);
        return "redirect:/borrowings/list";
    }
}
