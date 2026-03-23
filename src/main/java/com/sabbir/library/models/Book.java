package com.sabbir.library.models;

public class Book {
    private int id;
    private String name;
    private String author;
    private String isbn;
    private int availableCopies;

    public Book() {}

    public Book(int id, String name, String author, String isbn, int availableCopies) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-20s | %-15s | %-7d |",
                id, name, author, isbn, availableCopies);
    }
}
