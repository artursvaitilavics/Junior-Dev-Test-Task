package com.ItemsBackEnd.service;

import com.ItemsBackEnd.model.Dvd;
import com.ItemsBackEnd.model.utils.ItemStatus;
import com.ItemsBackEnd.repository.ItemRepository;
import com.ItemsBackEnd.validator.ItemValid;
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
            dvd.setStatus(ItemStatus.ACTIVE);
            Dvd savedDvd = repository.save(dvd);
            savedDvd.setSku("DVD" + savedDvd.getId());
            return repository.save(savedDvd);
        } else {
            return dvd;
        }
    }
}
