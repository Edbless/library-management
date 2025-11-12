package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Book;
import com.example.libraryresourcemanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookManager implements BookService {

    @Autowired
    BookRepository repository;



    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Book not found with id " + id));
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book updated) {
        Book book = getBookById(id);
        book.setTitle(updated.getTitle());
        book.setYr_published(updated.getYr_published());
        book.setQuantity(updated.getQuantity());
        book.setAuthor(updated.getAuthor());
        return repository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void addBook(Book book) {

    }
}
