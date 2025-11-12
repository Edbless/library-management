package com.example.libraryresourcemanagement.controller;

import com.example.libraryresourcemanagement.entity.Book;
import com.example.libraryresourcemanagement.service.AuthorManager;
import com.example.libraryresourcemanagement.service.BookManager;
import com.example.libraryresourcemanagement.service.LibrarianManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookManager bookManager;

    @Autowired
    private AuthorManager authorManager;

    @Autowired
    private LibrarianManager librarianManager; // added

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", bookManager.getAllBooks());
        return "books/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorManager.getAllAuthors());
        model.addAttribute("librarians", librarianManager.getAllLibrarians());
        return "books/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {
        bookManager.addBook(book);
        return "redirect:/books/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBook(@RequestParam Long id) {
        bookManager.deleteBook(id);
        return "redirect:/books/list";
    }
}
