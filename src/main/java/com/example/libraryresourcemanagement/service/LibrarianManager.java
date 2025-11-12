package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Librarian;
import com.example.libraryresourcemanagement.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibrarianManager implements LibrarianService {

    @Autowired
    LibrarianRepository repository;


    @Override
    public void saveLibrarian(Librarian librarian) {
        repository.save(librarian);
    }

    @Override
    public Librarian getLibrarianById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Librarian not found with id " + id));
    }

    @Override
    public List<Librarian> getAllLibrarians() {
        return repository.findAll();
    }

    @Override
    public Librarian updateLibrarian(Long id, Librarian updated) {
        Librarian librarian = getLibrarianById(id);
        librarian.setFullName(updated.getFullName());
        librarian.setEmail(updated.getEmail());
        librarian.setPhoneNumber(updated.getPhoneNumber());
        librarian.setPassword(updated.getPassword());
        return repository.save(librarian);
    }

    @Override
    public void deleteLibrarian(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public void addLibrarian(Librarian librarian) {
//        repository.addLibrarian(librarian);
//    }
}
