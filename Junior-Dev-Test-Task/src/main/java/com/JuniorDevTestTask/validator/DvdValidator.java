package com.JuniorDevTestTask.validator;

import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.model.Item;
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
