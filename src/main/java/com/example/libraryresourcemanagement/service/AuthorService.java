package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Author;
import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    Author getAuthorById(Long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);

//    void addAuthor(Author author);

}
