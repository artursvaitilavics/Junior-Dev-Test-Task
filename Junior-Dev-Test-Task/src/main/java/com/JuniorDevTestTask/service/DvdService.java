package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DvdService {

    private final ItemRepository repository;

    @Autowired
    public DvdService(ItemRepository repository) {
        this.repository = repository;
    }

    public Dvd save(Dvd item) {
        String property = "Size: " + item.getProperty() + "MB";
        item.setProperty(property);
        return repository.save(item);
    }
}
