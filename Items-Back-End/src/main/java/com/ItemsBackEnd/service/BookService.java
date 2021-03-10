package com.ItemsBackEnd.service;

import com.ItemsBackEnd.model.Book;
import com.ItemsBackEnd.model.utils.ItemStatus;
import com.ItemsBackEnd.repository.ItemRepository;
import com.ItemsBackEnd.validator.ItemValid;
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
            book.setStatus(ItemStatus.ACTIVE);
            Book savedBook = repository.save(book);
            savedBook.setSku("BK" + savedBook.getId());
            return repository.save(savedBook);
        } else {

            return book;
        }
    }
}
