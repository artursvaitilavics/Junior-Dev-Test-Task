package com.JuniorDevTestTask.validator;

import com.JuniorDevTestTask.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookValidator implements ItemValid<Book>{

    @Override
    public boolean isValid(Book book) {
        if (book.getName().equals("") || book.getPrice().equals("") || book.getProperty().equals("")) {
            return false;
        }
        return true;
    }
}
