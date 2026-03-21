package com.sabbir.library.models;

import java.time.LocalDate;

public class Borrow {
    private int id;
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrow() {}

    public Borrow(int id, int bookId, int memberId) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
    }

    public Borrow(int id, LocalDate returnDate, LocalDate borrowDate, int memberId, int bookId) {
        this.id = id;
        this.returnDate = returnDate;
        this.borrowDate = borrowDate;
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
