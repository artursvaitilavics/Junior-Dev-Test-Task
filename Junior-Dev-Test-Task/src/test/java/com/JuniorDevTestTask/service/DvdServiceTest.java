package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Book;
import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.ItemValid;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DvdServiceTest {

    public ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
    public ItemValid itemValidator = Mockito.mock(ItemValid.class);
    public DvdService itemService = new DvdService(itemRepository, itemValidator);


    @Test
    void save() {
        Dvd dvd1 = new Dvd();
        dvd1.setId(1L);
        dvd1.setName("ACCER MP3");
        dvd1.setProperty("700");
        dvd1.setPrice(1L);

        Dvd dvd2 = new Dvd();
        dvd2.setId(2L);
        dvd2.setName("ACME DVD");
        dvd2.setProperty("4813");
        dvd2.setPrice(2L);

        Mockito.when(itemValidator.isValid(dvd1)).thenReturn(true);
        Mockito.when(itemRepository.save(dvd1)).thenReturn(dvd1);
        Mockito.when(itemValidator.isValid(dvd2)).thenReturn(true);
        Mockito.when(itemRepository.save(dvd2)).thenReturn(dvd2);

        Item result1 = itemService.save(dvd1);
        Item result2 = itemService.save(dvd2);

        assertEquals("ACCER MP3", result1.getName());
        assertEquals("ACME DVD", result2.getName());
        assertEquals("DVD1", result1.getSku());
        assertEquals("DVD2", result2.getSku());
        assertEquals("Size: 700 MB", result1.getProperty());
        assertEquals("Size: 4813 MB", result2.getProperty());

    }

}