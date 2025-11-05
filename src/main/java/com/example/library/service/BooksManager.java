package com.example.library.service;

import com.example.library.entity.Books;
import com.example.library.respository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BooksManager implements BooksService {

    private final BookRepository repository;

    public BooksManager(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Books> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Books getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Books addBook(Books book) {
        return repository.save(book);
    }

    @Override
    public Books updateBook(Long id, Books updated) {
        Books existing = getBookById(id);
        existing.setTitle(updated.getTitle());
        existing.setIsbn(updated.getIsbn());
        existing.setAuthor(updated.getAuthor());
        return repository.save(existing);
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
