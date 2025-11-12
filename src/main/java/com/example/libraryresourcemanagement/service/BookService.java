package com.example.libraryresourcemanagement.service;



import com.example.libraryresourcemanagement.entity.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);

    void addBook(Book book);

}
