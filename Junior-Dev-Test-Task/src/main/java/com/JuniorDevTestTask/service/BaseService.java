package com.JuniorDevTestTask.service;

import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.model.utils.BaseItem;
import com.JuniorDevTestTask.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseService {

    private final BaseRepository baseRepository;

    @Autowired
    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public Item save(Item item){
        return baseRepository.save(item);
    }

    public List<Item> findAll(){
        return baseRepository.findAll();
    }
}
