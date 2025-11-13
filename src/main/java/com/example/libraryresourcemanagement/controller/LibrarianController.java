package com.example.libraryresourcemanagement.controller;

import com.example.libraryresourcemanagement.entity.Librarian;
import com.example.libraryresourcemanagement.service.LibrarianManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianManager librarianManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listLibrarians(Model model) {
        model.addAttribute("librarians", librarianManager.getAllLibrarians());
        return "librarians/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("librarian", new Librarian());
        return "librarians/form";
    }

    // GET mapping for edit
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Librarian librarian = librarianManager.getLibrarianById(id);
        model.addAttribute("librarian", librarian);
        return "librarians/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLibrarian(@ModelAttribute Librarian librarian) {
        librarianManager.saveLibrarian(librarian); // Save or update depending on ID
        return "redirect:/librarians/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteLibrarian(@RequestParam Long id) {
        librarianManager.deleteLibrarian(id);
        return "redirect:/librarians/list";
    }
}
