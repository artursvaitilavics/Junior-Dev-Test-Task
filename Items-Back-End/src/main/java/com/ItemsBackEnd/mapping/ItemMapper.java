package com.ItemsBackEnd.mapping;

import com.ItemsBackEnd.dto.ItemDto;
import com.ItemsBackEnd.model.Item;
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
