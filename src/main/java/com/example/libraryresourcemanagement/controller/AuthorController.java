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

    // GET mapping for edit
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Author author = authorManager.getAuthorById(id);
        model.addAttribute("author", author);
        return "authors/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuthor(@ModelAttribute Author author) {
        authorManager.saveAuthor(author); // save or update depending on ID
        return "redirect:/authors/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAuthor(@RequestParam Long id) {
        authorManager.deleteAuthor(id);
        return "redirect:/authors/list";
    }
}
