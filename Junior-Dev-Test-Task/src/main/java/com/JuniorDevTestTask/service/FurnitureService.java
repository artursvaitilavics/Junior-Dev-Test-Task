package com.JuniorDevTestTask.service;


import com.JuniorDevTestTask.model.Furniture;
import com.JuniorDevTestTask.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FurnitureService {

    private final ItemRepository repository;

    @Autowired
    public FurnitureService(ItemRepository repository) {
        this.repository = repository;
    }

    public Furniture save(Furniture furniture) {
        String property = "Dimensions: " + furniture.getProperty();
        furniture.setProperty(property);
        Furniture savedFurniture = repository.save(furniture);
        savedFurniture.setSku("FRN" + savedFurniture.getId());
        return repository.save(savedFurniture);
    }
}
