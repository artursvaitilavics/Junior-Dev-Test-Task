package com.JuniorDevTestTask.service;


import com.JuniorDevTestTask.model.Furniture;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.ItemValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FurnitureService {

    private final ItemRepository repository;
    private final ItemValid itemValidator;

    @Autowired
    public FurnitureService(ItemRepository repository, ItemValid itemValidator) {
        this.repository = repository;
        this.itemValidator = itemValidator;
    }

    public Furniture save(Furniture furniture) {
        if (itemValidator.isValid(furniture)) {
            String property = "Dimensions: " + furniture.getProperty();
            furniture.setProperty(property);
            Furniture savedFurniture = repository.save(furniture);
            savedFurniture.setSku("FRN" + savedFurniture.getId());
            return repository.save(savedFurniture);
        } else {
            return furniture;
        }
    }
}
