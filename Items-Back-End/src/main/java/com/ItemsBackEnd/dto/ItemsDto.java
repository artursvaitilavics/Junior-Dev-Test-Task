package com.ItemsBackEnd.dto;

import com.ItemsBackEnd.model.Item;

import java.util.List;

public class ItemsDto {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
