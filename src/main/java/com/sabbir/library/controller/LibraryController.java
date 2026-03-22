

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
        borrowService = new BorrowService(borrowRepo, bookRepo);
    }

    public void start() {

        while (true) {
            List<Book> books =
                    JsonStorage.load("src/main/resources/data/books.json",
                            new TypeReference<List<Book>>() {});

            for (Book b : books) {
                bookService.addBook(b.getId(), b);
            }

            System.out.println("\n1 Add Book\n2 View Books\n3 Delete Book\n4 Borrow Book\n5 Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> deleteBook();
                case 4 -> borrowBook();
                case 5 -> System.exit(0);
            }


            JsonStorage.save(
                    "src/main/resources/data/books.json",
                    bookService.findAll()
            );
        }
    }

    private void addBook() {
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        Book book = new Book((int)(Math.random()*1000), title, author, "#001", 5);
        bookService.addBook(book.getId(), book);
    }

    private void viewBooks() {
        for (Book b : bookService.findAll()) {
            System.out.println(b);
        }
    }

    private void deleteBook() {
        System.out.print("Book ID: ");
        int bookId = sc.nextInt();

        bookService.delete(bookId);
    }

    private void borrowBook() {
        System.out.print("Book ID: ");
        int bookId = sc.nextInt();

        borrowService.borrowBook(bookId, 1, (int)(Math.random()*1000));
    }
}