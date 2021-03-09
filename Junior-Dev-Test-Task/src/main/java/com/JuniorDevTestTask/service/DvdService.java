package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.repository.ItemRepository;
import com.JuniorDevTestTask.validator.ItemValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DvdService {

    private final ItemRepository repository;
    private final ItemValid itemValidator;

    @Autowired
    public DvdService(ItemRepository repository, ItemValid itemValidator) {
        this.repository = repository;
        this.itemValidator = itemValidator;
    }

    public Dvd save(Dvd dvd) {
        if (itemValidator.isValid(dvd)) {
            String property = "Size: " + dvd.getProperty() + " MB";
            dvd.setProperty(property);
            Dvd savedDvd = repository.save(dvd);
            savedDvd.setSku("DVD" + savedDvd.getId());
            return repository.save(savedDvd);
        } else {
            return dvd;
        }
    }
}
