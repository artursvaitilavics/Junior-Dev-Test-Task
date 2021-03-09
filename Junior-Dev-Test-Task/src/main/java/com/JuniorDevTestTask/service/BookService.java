package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Book;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.BookValidator;
import com.JuniorDevTestTask.validator.ItemValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private final ItemRepository repository;
    private final ItemValid itemValidator;

    @Autowired
    public BookService(ItemRepository repository, ItemValid itemValidator) {
        this.repository = repository;
        this.itemValidator = itemValidator;
    }

    public Book save(Book book) {
        if (itemValidator.isValid(book)) {
            String property = "Weight: " + book.getProperty() + " KG";
            book.setProperty(property);
            Book savedBook = repository.save(book);
            savedBook.setSku("BK" + savedBook.getId());
            return repository.save(savedBook);
        } else {

            return book;
        }
    }
}
