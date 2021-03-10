package com.ItemsBackEnd.service;

import com.ItemsBackEnd.model.Furniture;
import com.ItemsBackEnd.model.Item;
import com.ItemsBackEnd.repository.ItemRepository;
import com.ItemsBackEnd.validator.ItemValid;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureServiceTest {


    public ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
    public ItemValid itemValidator = Mockito.mock(ItemValid.class);
    public FurnitureService itemService = new FurnitureService(itemRepository, itemValidator);


    @Test
    void save() {
        Furniture furniture1 = new Furniture();
        furniture1.setId(1L);
        furniture1.setName("Chair");
        furniture1.setProperty("12x25x55");
        furniture1.setPrice(15L);

        Furniture furniture2 = new Furniture();
        furniture2.setId(2L);
        furniture2.setName("Table");
        furniture2.setProperty("16x45x78");
        furniture2.setPrice(15L);

        Mockito.when(itemValidator.isValid(furniture1)).thenReturn(true);
        Mockito.when(itemRepository.save(furniture1)).thenReturn(furniture1);
        Mockito.when(itemValidator.isValid(furniture2)).thenReturn(true);
        Mockito.when(itemRepository.save(furniture2)).thenReturn(furniture2);

        Item result1 = itemService.save(furniture1);
        Item result2 = itemService.save(furniture2);

        assertEquals("Chair", result1.getName());
        assertEquals("Table", result2.getName());
        assertEquals("FRN1", result1.getSku());
        assertEquals("FRN2", result2.getSku());
        assertEquals("Dimensions: 12x25x55", result1.getProperty());
        assertEquals("Dimensions: 16x45x78", result2.getProperty());

    }

}