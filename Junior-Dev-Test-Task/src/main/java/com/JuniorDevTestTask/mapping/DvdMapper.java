package com.JuniorDevTestTask.mapping;

import com.JuniorDevTestTask.dto.ItemDto;
import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.model.utils.ItemType;
import org.springframework.stereotype.Component;


@Component
public class DvdMapper {
    public ItemDto toDto(Dvd dvd) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(dvd.getId());
        itemDto.setSku(dvd.getSku());
        itemDto.setName(dvd.getName());
        itemDto.setType(dvd.getType().name());
        itemDto.setPrice(dvd.getPrice());
        itemDto.setProperty(dvd.getProperty());
        return itemDto;
    }

    public Dvd fromDto(ItemDto itemDto) {
        Dvd item = new Dvd();
        item.setSku(itemDto.getSku());
        item.setName(itemDto.getName());
        item.setType(ItemType.valueOf(itemDto.getType()));
        item.setPrice(itemDto.getPrice());
        item.setProperty(itemDto.getProperty());
        return item;
    }
}
