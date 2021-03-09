package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.ItemValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemValid itemValidator;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemValid itemValidator) {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;

    }

    public Item save(Item item) {
        if (itemValidator.isValid(item)) {
            return itemRepository.save(item);
        } else {
            return null;
        }

    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
