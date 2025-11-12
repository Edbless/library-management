package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Author;
import com.example.libraryresourcemanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorManager implements AuthorService {

    @Autowired
    AuthorRepository repository;


    @Override
    public Author saveAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Author not found with id " + id));
    }

    @Override
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author updated) {
        Author author = getAuthorById(id);
        author.setFullName(updated.getFullName());
        author.setContact(updated.getContact());
        author.setAddress(updated.getAddress());
        return repository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public void addAuthor(Author author) {
//        repository.addAuthor(author);
//    }
}
