package com.example.libraryresourcemanagement.service;


import com.example.libraryresourcemanagement.entity.Borrowing;
import com.example.libraryresourcemanagement.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowingManager implements BorrowingService {

    @Autowired
    BorrowingRepository repository;



    @Override
    public void saveBorrowing(Borrowing borrowing) {
        repository.save(borrowing);
    }

    @Override
    public Borrowing getBorrowingById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Borrowing not found with id " + id));
    }

    @Override
    public List<Borrowing> getAllBorrowings() {
        return repository.findAll();
    }

    @Override
    public Borrowing updateBorrowing(Long id, Borrowing updated) {
        Borrowing borrowing = getBorrowingById(id);
        borrowing.setBorrowedDate(updated.getBorrowedDate());
        borrowing.setReturnDate(updated.getReturnDate());
        borrowing.setBook(updated.getBook());
        borrowing.setStudent(updated.getStudent());
        return repository.save(borrowing);
    }

    @Override
    public void deleteBorrowing(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public void addBorrowing(Borrowing borrowing) {
//        repository.addBorrowing(borrowing);
//    }
}
