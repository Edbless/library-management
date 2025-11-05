package com.example.library.controller;

import com.example.library.entity.Books;
import com.example.library.service.BooksService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService service;

    public BooksController(BooksService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Books> getAllBooks() {
        return service.getAllBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Books getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Books addBook(@RequestBody Books book) {
        return service.addBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Books updateBook(@PathVariable Long id, @RequestBody Books updated) {
        return service.updateBook(id, updated);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}
