package com.sabbir.library.service;

import com.sabbir.library.models.Book;
import com.sabbir.library.repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository repo;

    public BookService(BookRepository repo){
        this.repo = repo;
    }

    public void addBook(int id, Book book){
        repo.save(book.getId(), book);
    }

    public Book findById(int id){
        return repo.findById(id);
    }

    public List<Book> findAll(){
        return repo.findAll();
    }

    public void delete(int id){
        repo.remove(id);
        System.out.println("Book has been removed!!");
    }
}
