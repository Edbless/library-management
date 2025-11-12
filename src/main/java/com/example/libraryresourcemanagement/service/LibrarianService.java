package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Librarian;
import java.util.List;

public interface LibrarianService {
    void saveLibrarian(Librarian librarian);
    Librarian getLibrarianById(Long id);
    List<Librarian> getAllLibrarians();
    Librarian updateLibrarian(Long id, Librarian librarian);
    void deleteLibrarian(Long id);
//    void addLibrarian(Librarian librarian);

}
