package com.ItemsBackEnd.service;

import com.ItemsBackEnd.model.Item;
import com.ItemsBackEnd.model.utils.ItemStatus;
import com.ItemsBackEnd.repository.ItemRepository;
import com.ItemsBackEnd.validator.ItemValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
            item.setStatus(ItemStatus.ACTIVE);
            return itemRepository.save(item);
        } else {
            return item;
        }
    }

    public Item update(Item item, Long id) throws Exception {
        itemRepository.findById(id).orElseThrow(() -> new Exception("Item with " + id + " id do not exist..."));
        item.setId(id);
        return  itemRepository.save(item);
    }

    public void delete(Long id) throws Exception {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new Exception("item with " + id + "id do not exist"));
        item.setStatus(ItemStatus.DELETED);
        itemRepository.save(item);
        System.out.println("DELETE FROM SERVICES");
    }

    public Item findById(Long id) throws Exception {
        return itemRepository.findById(id).orElseThrow(() -> new Exception("item with " + id + "id do not exist"));
    }

    public List<Item> findAll() {
        return itemRepository.findAll().stream().filter(item -> item.getStatus() == ItemStatus.ACTIVE).collect(Collectors.toList());
    }
}
