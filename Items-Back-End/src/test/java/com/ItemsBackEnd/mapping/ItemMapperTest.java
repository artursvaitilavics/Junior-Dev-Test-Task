package com.ItemsBackEnd.mapping;

import com.ItemsBackEnd.dto.FurnitureDto;
import com.ItemsBackEnd.dto.ItemDto;
import com.ItemsBackEnd.model.Furniture;
import com.ItemsBackEnd.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {
    public ItemMapper mapper = new ItemMapper();

    @Test
    void toDto() {
        Furniture furniture = new Furniture();
        furniture.setId(1L);
        furniture.setName("Chair");
        furniture.setProperty("12x25x55");
        furniture.setPrice(15L);


        ItemDto result = mapper.toDto(furniture);

        assertEquals("Chair", result.getName());
        assertEquals(1L, result.getId());


    }

    @Test
    void fromDto() {
        FurnitureDto furnitureDto = new FurnitureDto();
        furnitureDto.setName("Chair");
        furnitureDto.setProperty("12x25x55");
        furnitureDto.setPrice(15L);

        Item result = mapper.fromDto(furnitureDto);

        assertEquals("Chair", result.getName());
        assertEquals(15L, result.getPrice());


    }
}