package com.JuniorDevTestTask.validator;

import com.JuniorDevTestTask.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookValidatorTest {

    @Test
    void isValid() {
        Book book = new Book();
        book.setId(1L);
        book.setName("Dune");
        book.setProperty("2");
        book.setPrice(15L);

        Book book2 = new Book();
        book2.setId(1L);
        book2.setName("");
        book2.setProperty("2");
        book2.setPrice(15L);

        BookValidator validator = new BookValidator();

        boolean result = validator.isValid(book);
        boolean result2 = validator.isValid(book2);

        assertTrue(result);
        assertFalse(result2);
    }
}