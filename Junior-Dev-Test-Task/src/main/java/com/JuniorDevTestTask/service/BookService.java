package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Book;
import com.JuniorDevTestTask.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private final ItemRepository repository;

    @Autowired
    public BookService(ItemRepository repository) {
        this.repository = repository;
    }

    public Book saveBook(Book book) {
        String property = "Weight: " + book.getProperty() + " KG";
        book.setProperty(property);
        return repository.save(book);
    }
}
