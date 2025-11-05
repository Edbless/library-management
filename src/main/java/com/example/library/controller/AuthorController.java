package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getAuthorById(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author) {
        return service.addAuthor(author);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updated) {
        return service.updateAuthor(id, updated);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
    }
}
