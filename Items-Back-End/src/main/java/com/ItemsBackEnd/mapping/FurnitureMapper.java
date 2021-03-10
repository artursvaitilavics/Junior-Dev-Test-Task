package com.ItemsBackEnd.mapping;

import com.ItemsBackEnd.dto.ItemDto;
import com.ItemsBackEnd.model.Furniture;
import org.springframework.stereotype.Component;

@Component
public class FurnitureMapper {
    public ItemDto toDto(Furniture furniture) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(furniture.getId());
        itemDto.setSku(furniture.getSku());
        itemDto.setName(furniture.getName());
        itemDto.setPrice(furniture.getPrice());
        itemDto.setProperty(furniture.getProperty());
        return itemDto;
    }

    public Furniture fromDto(ItemDto itemDto) {
        Furniture furniture = new Furniture();
        furniture.setSku(itemDto.getSku());
        furniture.setName(itemDto.getName());
        furniture.setPrice(itemDto.getPrice());
        furniture.setProperty(itemDto.getProperty());
        return furniture;
    }
}
