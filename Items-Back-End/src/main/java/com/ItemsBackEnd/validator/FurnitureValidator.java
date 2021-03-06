package com.ItemsBackEnd.validator;

import com.ItemsBackEnd.model.Furniture;
import org.springframework.stereotype.Component;

@Component
public class FurnitureValidator implements ItemValid<Furniture> {
    @Override
    public boolean isValid(Furniture furniture) {
        if (furniture.getName().equals("") || furniture.getPrice().equals("") || furniture.getProperty().equals("")) {
            return false;
        }
        return true;
    }
}
