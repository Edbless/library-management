package com.example.library.service;

import com.example.library.entity.Books;
import java.util.List;

public interface BooksService {
    List<Books> getAllBooks();
    Books getBookById(Long id);
    Books addBook(Books book);
    Books updateBook(Long id, Books updated);
    void deleteBook(Long id);
}
