package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Book;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.ItemValid;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    public ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
    public ItemValid itemValidator = Mockito.mock(ItemValid.class);
    public BookService itemService = new BookService(itemRepository, itemValidator);


    @Test
    void save() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Dune");
        book1.setProperty("2");
        book1.setPrice(15L);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setName("LOTR");
        book2.setProperty("3");
        book2.setPrice(15L);

        Mockito.when(itemValidator.isValid(book1)).thenReturn(true);
        Mockito.when(itemRepository.save(book1)).thenReturn(book1);
        Mockito.when(itemValidator.isValid(book2)).thenReturn(true);
        Mockito.when(itemRepository.save(book2)).thenReturn(book2);

        Item result1 = itemService.save(book1);
        Item result2 = itemService.save(book2);

        assertEquals("Dune", result1.getName());
        assertEquals("LOTR", result2.getName());
        assertEquals("BK1", result1.getSku());
        assertEquals("BK2", result2.getSku());
        assertEquals("Weight: 2 KG", result1.getProperty());
        assertEquals("Weight: 3 KG", result2.getProperty());

    }

}