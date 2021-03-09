package com.JuniorDevTestTask.validator;

import com.JuniorDevTestTask.model.Furniture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureValidatorTest {

    @Test
    void isValid() {

        Furniture furniture1 = new Furniture();
        furniture1.setId(1L);
        furniture1.setName("Chair");
        furniture1.setProperty("12x25x55");
        furniture1.setPrice(15L);

        Furniture furniture2 = new Furniture();
        furniture2.setId(2L);
        furniture2.setName("");
        furniture2.setProperty("16x45x78");
        furniture2.setPrice(15L);


        FurnitureValidator validator = new FurnitureValidator();

        boolean result = validator.isValid(furniture1);
        boolean result2 = validator.isValid(furniture2);

        assertTrue(result);
        assertFalse(result2);
    }
}