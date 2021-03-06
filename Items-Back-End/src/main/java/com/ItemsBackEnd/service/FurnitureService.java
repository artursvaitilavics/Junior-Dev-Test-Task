package com.ItemsBackEnd.service;


import com.ItemsBackEnd.model.Furniture;
import com.ItemsBackEnd.model.utils.ItemStatus;
import com.ItemsBackEnd.repository.ItemRepository;
import com.ItemsBackEnd.validator.ItemValid;
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
            furniture.setStatus(ItemStatus.ACTIVE);
            Furniture savedFurniture = repository.save(furniture);
            savedFurniture.setSku("FRN" + savedFurniture.getId());
            return repository.save(savedFurniture);
        } else {
            return furniture;
        }
    }
}
