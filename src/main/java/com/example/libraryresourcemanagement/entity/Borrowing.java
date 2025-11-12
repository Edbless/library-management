package com.example.libraryresourcemanagement.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrowings")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String borrowedBookTitle;
    private String borrowedBookAuthor;
    private LocalDate borrowedDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Constructors
    public Borrowing (){}
    public Borrowing(Long id, String borrowedBookTitle, String borrowedBookAuthor, LocalDate borrowedDate, LocalDate returnDate) {
        this.id = id;
        this.borrowedBookTitle = borrowedBookTitle;
        this.borrowedBookAuthor = borrowedBookAuthor;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowedBookTitle() {
        return borrowedBookTitle;
    }

    public void setBorrowedBookTitle(String borrowedBookTitle) {
        this.borrowedBookTitle = borrowedBookTitle;
    }

    public String getBorrowedBookAuthor() {
        return borrowedBookAuthor;
    }

    public void setBorrowedBookAuthor(String borrowedBookAuthor) {
        this.borrowedBookAuthor = borrowedBookAuthor;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

