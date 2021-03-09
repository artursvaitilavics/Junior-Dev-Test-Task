package com.JuniorDevTestTask.mapping;

import com.JuniorDevTestTask.dto.DvdDto;
import com.JuniorDevTestTask.dto.FurnitureDto;
import com.JuniorDevTestTask.dto.ItemDto;
import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.model.Furniture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DvdMapperTest {
    public DvdMapper mapper = new DvdMapper();

    @Test
    void toDto() {
        Dvd dvd = new Dvd();
        dvd.setId(1L);
        dvd.setName("ACCER MP3");
        dvd.setProperty("700");
        dvd.setPrice(1L);


        ItemDto result = mapper.toDto(dvd);

        assertEquals("ACCER MP3", result.getName());
        assertEquals(1L, result.getId());


    }

    @Test
    void fromDto() {
        DvdDto dvd = new DvdDto();
        dvd.setId(1L);
        dvd.setName("ACCER MP3");
        dvd.setProperty("700");
        dvd.setPrice(1L);

        Dvd result = mapper.fromDto(dvd);

        assertEquals("ACCER MP3", result.getName());
        assertEquals(1L, result.getPrice());


    }
}