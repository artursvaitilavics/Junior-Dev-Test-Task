package com.JuniorDevTestTask.validator;

import com.JuniorDevTestTask.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemValidator implements ItemValid<Item> {


    @Override
    public boolean isValid(Item item) {
        if (item.getName().equals("") || item.getPrice().equals("") || item.getProperty().equals("")) {
            return false;
        }
        return true;
    }
}
