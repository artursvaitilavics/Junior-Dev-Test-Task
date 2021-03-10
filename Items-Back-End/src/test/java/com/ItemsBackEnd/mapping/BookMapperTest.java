package com.ItemsBackEnd.mapping;

import com.ItemsBackEnd.dto.BookDto;
import com.ItemsBackEnd.dto.ItemDto;
import com.ItemsBackEnd.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {
    public BookMapper mapper = new BookMapper();

    @Test
    void toDto() {
        Book book = new Book();
        book.setId(1L);
        book.setName("Dune");
        book.setProperty("2");
        book.setPrice(15L);

        ItemDto result = mapper.toDto(book);

        assertEquals("Dune", result.getName());
        assertEquals(1L, result.getId());


    }

    @Test
    void fromDto() {
        BookDto book = new BookDto();
        book.setId(1L);
        book.setName("Dune");
        book.setProperty("2");
        book.setPrice(15L);

        Book result = mapper.fromDto(book);

        assertEquals("Dune", result.getName());
        assertEquals(15L, result.getPrice());


    }

}