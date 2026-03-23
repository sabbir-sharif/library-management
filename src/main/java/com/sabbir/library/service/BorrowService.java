package com.sabbir.library.service;

import com.sabbir.library.models.Book;
import com.sabbir.library.models.Borrow;
import com.sabbir.library.models.Member;
import com.sabbir.library.repository.BookRepository;
import com.sabbir.library.repository.BorrowRepository;
import com.sabbir.library.repository.MemberRepository;

import java.util.List;

public class BorrowService {

    private BorrowRepository borrowRepo;
    private BookRepository bookRepo;
    private MemberRepository memberRepo;

    public BorrowService() {
    }

    public BorrowService(BorrowRepository borrowRepo,
                         BookRepository bookRepo,
                         MemberRepository memberRepo) {
        this.borrowRepo = borrowRepo;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public void borrowBook(int bookId, int memberId, int borrowId){
        Book book = bookRepo.findById(bookId);
        Member  member = memberRepo.findById(memberId);

        if(book == null){
            System.out.println("Book not found!!");
            return;
        }

        if(member == null){
            System.out.println("Member not found!!");
            return;
        }

        if(book.getAvailableCopies() <= 0){
            System.out.println("Book is not available now!!");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        Borrow borrow =new Borrow(borrowId, bookId, memberId);
        borrowRepo.save(borrowId, borrow);

        System.out.println("Book borrowed successfully!");
    }

    public void returnBook(int id){
        Book book = bookRepo.findById(id);
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        bookRepo.save(id, book);

        System.out.println("Book returned successfully! :)");
    }

    public List<Borrow> findAll(){
        return borrowRepo.findAll();
    }
}
