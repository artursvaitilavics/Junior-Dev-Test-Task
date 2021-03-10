package com.ItemsBackEnd.validator;

import com.ItemsBackEnd.model.Dvd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DvdValidatorTest {

    @Test
    void isValid() {
        Dvd dvd1 = new Dvd();
        dvd1.setId(1L);
        dvd1.setName("ACCER MP3");
        dvd1.setProperty("700");
        dvd1.setPrice(1L);

        Dvd dvd2 = new Dvd();
        dvd2.setId(2L);
        dvd2.setName("ACME DVD");
        dvd2.setProperty("");
        dvd2.setPrice(2L);

        DvdValidator validator = new DvdValidator();

        boolean result = validator.isValid(dvd1);
        boolean result2 = validator.isValid(dvd2);

        assertTrue(result);
        assertFalse(result2);
    }
}