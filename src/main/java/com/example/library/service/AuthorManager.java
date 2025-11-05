package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.respository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorManager implements AuthorService {

    private final AuthorRepository repository;

    public AuthorManager(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author updated) {
        Author existing = getAuthorById(id);
        existing.setName(updated.getName());
        existing.setNationality(updated.getNationality());
        return repository.save(existing);
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}
