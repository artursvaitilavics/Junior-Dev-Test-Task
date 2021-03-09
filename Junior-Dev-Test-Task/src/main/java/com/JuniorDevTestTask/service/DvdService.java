package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Dvd;
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

    public Dvd save(Dvd dvd) {
        String property = "Size: " + dvd.getProperty() + " MB";
        dvd.setProperty(property);
        Dvd savedDvd  = repository.save(dvd);
        savedDvd.setSku("DVD" + savedDvd.getId());
        return repository.save(savedDvd);
    }
}
