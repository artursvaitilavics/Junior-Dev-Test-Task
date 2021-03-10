package com.ItemsBackEnd.validator;

import com.ItemsBackEnd.model.Dvd;
import org.springframework.stereotype.Component;

@Component
public class DvdValidator implements ItemValid<Dvd>{

    @Override
    public boolean isValid(Dvd dvd) {
        if (dvd.getName().equals("") || dvd.getPrice().equals("") || dvd.getProperty().equals("")) {
            return false;
        }
        return true;
    }
}
