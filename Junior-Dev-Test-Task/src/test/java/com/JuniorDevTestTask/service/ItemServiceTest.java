package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.ItemValid;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ItemServiceTest {

    public ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
    public ItemValid itemValidator = Mockito.mock(ItemValid.class);
    public ItemService itemService = new ItemService(itemRepository, itemValidator);


    @Test
    void save() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("Dune");
        item1.setProperty("2");
        item1.setPrice(15L);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("LOTR");
        item2.setProperty("3");
        item2.setPrice(15L);

        Mockito.when(itemValidator.isValid(item1)).thenReturn(true);
        Mockito.when(itemRepository.save(item1)).thenReturn(item1);

        Item result1 = itemService.save(item1);
        Item result2 = itemService.save(item2);

        assertEquals("Dune", result1.getName());
        assertEquals("LOTR", result2.getName());

    }

    @Test
    void findAll() {

        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("Dune");
        item1.setProperty("2");
        item1.setPrice(15L);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("LOTR");
        item2.setProperty("3");
        item2.setPrice(15L);

        List<Item> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);

        Mockito.when(itemRepository.findAll()).thenReturn(items);

        List<Item> result = itemService.findAll();

        assertEquals("Dune", result.get(0).getName());
        assertEquals("LOTR", result.get(1).getName());


    }
}