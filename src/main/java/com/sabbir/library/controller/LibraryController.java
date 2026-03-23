

package com.sabbir.library.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sabbir.library.localdb.JsonStorage;
import com.sabbir.library.models.*;
import com.sabbir.library.service.*;

import java.util.List;
import java.util.Scanner;

public class LibraryController {

    private BookService bookService;
    private MemberService memberService;
    private BorrowService borrowService;

    private Scanner sc = new Scanner(System.in);

    public LibraryController() {

        var bookRepo = new com.sabbir.library.repository.BookRepository();
        var memberRepo = new com.sabbir.library.repository.MemberRepository();
        var borrowRepo = new com.sabbir.library.repository.BorrowRepository();

        bookService = new BookService(bookRepo);
        memberService = new MemberService(memberRepo);
        borrowService = new BorrowService(borrowRepo, bookRepo, memberRepo);
    }

    public void start() {

        while (true) {
            List<Book> books =
                    JsonStorage.load("src/main/resources/data/books.json",
                            new TypeReference<List<Book>>() {});

            List<Member> members =
                    JsonStorage.load("src/main/resources/data/members.json",
                            new TypeReference<List<Member>>() {});

            List<Borrow>  borrows =
                    JsonStorage.load("src/main/resources/data/borrow.json",
                            new TypeReference<List<Borrow>>() {});

            for (Book b : books) {
                bookService.addBook(b.getId(), b);
            }

            for (Member m : members){
                memberService.addMember(m.getId(), m);
            }

            for (Borrow br : borrows){
                borrowService.borrowBook(br.getBookId(), br.getMemberId(), br.getId());
            }

            System.out.println("\n1 Add Book\n2 View Books\n3 Delete Book\n4 Add Member\n5 Delete Member\n6 View All Members\n7 Borrow Book\n8 Return Book\n9 Borrow History\n10 Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> deleteBook();
                case 4 -> addMember();
                case 5 -> deleteMember();
                case 6 -> viewMembers();
                case 7 -> borrowBook();
                case 8 -> returnBook();
                case 9 -> borrowHistory();
                case 10 -> System.exit(0);
            }


            JsonStorage.save(
                    "src/main/resources/data/books.json",
                    bookService.findAll()
            );

            JsonStorage.save(
                    "src/main/resources/data/members.json",
                    memberService.findAll()
            );

            JsonStorage.save(
                    "src/main/resources/data/borrow.json",
                    borrowService.findAll()
            );
        }
    }

    private void addBook() {
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Amount of Coppies: ");
        int copies = sc.nextInt();

        Book book = new Book((int)(Math.random()*1000), title, author, isbn, copies);
        bookService.addBook(book.getId(), book);
    }

    private void viewBooks() {
        String id = "ID", name = "Name", author = "Author", isbn="ISBN", availableCopies = "AV. C.";
        System.out.printf("| %-5s | %-20s | %-20s | %-15s | %-7s |\n",
                id, name, author, isbn, availableCopies);
        for (Book b : bookService.findAll()) {
            System.out.println(b);
        }
    }

    private void deleteBook() {
        System.out.print("Book ID: ");
        int bookId = sc.nextInt();

        bookService.delete(bookId);
    }

    private void addMember(){
        sc.nextLine();
        System.out.println("Member Name: ");
        String name = sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        System.out.println("Phone: ");
        String phone = sc.nextLine();

        Member member = new Member((int)(Math.random()*1000), phone, email, name);
        memberService.addMember(member.getId(), member);
    }

    private void viewMembers(){
        String id = "ID", name="Name", email="Email", phone="Phone";
        System.out.printf("| %-5s | %-20s | %-25s | %-15s |\n",
                id, name, email, phone);
        for (Member m: memberService.findAll()){
            System.out.println(m);
        }
    }

    private void deleteMember(){
        System.out.println("Member Id: ");
        int memberId = sc.nextInt();
        memberService.delete(memberId);
    }

    private void borrowBook() {
        System.out.print("Book Id: ");
        int bookId = sc.nextInt();

        System.out.print("Member Id: ");
        int memberId = sc.nextInt();

        borrowService.borrowBook(bookId, memberId, (int)(Math.random()*1000));
        //System.out.println("Book borrowed successfully!");
    }

    private void returnBook(){
        System.out.println("Book Id: ");
        int bookId = sc.nextInt();
        borrowService.returnBook(bookId);
        System.out.println("Book returned successfully!");
    }

    private void borrowHistory(){
        String id = "Id", bookId = "B. ID", memberId = "M. ID", borrowDate= "Borrow", returnDate="Return";
        System.out.printf("| %-5s | %-7s | %-9s | %-12s | %-12s |\n",
                id, bookId, memberId, borrowDate, returnDate);
        for (Borrow br: borrowService.findAll()){
            System.out.println(br);
        }
    }
}