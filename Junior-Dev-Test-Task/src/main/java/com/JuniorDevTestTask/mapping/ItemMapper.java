package com.JuniorDevTestTask.mapping;

import com.JuniorDevTestTask.dto.ItemDto;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.model.utils.ItemType;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setSku(item.getSku());
        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());
        itemDto.setProperty(item.getProperty());
        return itemDto;
    }

    public Item fromDto(ItemDto itemDto) {
        Item item = new Item();
        item.setSku(itemDto.getSku());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        return item;
    }
}
