package com.example.library.service;

import com.example.library.entity.Author;
import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author addAuthor(Author author);
    Author updateAuthor(Long id, Author updated);
    void deleteAuthor(Long id);
}
