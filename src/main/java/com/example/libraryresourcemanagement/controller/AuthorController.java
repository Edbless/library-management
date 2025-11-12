package com.example.libraryresourcemanagement.controller;


import com.example.libraryresourcemanagement.entity.Author;
import com.example.libraryresourcemanagement.service.AuthorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorManager authorManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorManager.getAllAuthors());
        return "authors/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuthor(@ModelAttribute Author author) {
        authorManager.saveAuthor(author);
        return "redirect:/authors/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAuthor(@RequestParam Long id) {
        authorManager.deleteAuthor(id);
        return "redirect:/authors/list";
    }
}

