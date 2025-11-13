package com.example.libraryresourcemanagement.service;

import com.example.libraryresourcemanagement.entity.Borrowing;
import java.util.List;

public interface BorrowingService {
    void saveBorrowing(Borrowing borrowing);
    Borrowing getBorrowingById(Long id);
    List<Borrowing> getAllBorrowings();
    Borrowing updateBorrowing(Long id, Borrowing borrowing);
    void deleteBorrowing(Long id);

    void editBorrowing(Borrowing borrowing);

//    void addBorrowing(Borrowing borrowing);
}
