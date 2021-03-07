package com.JuniorDevTestTask.model;

import com.JuniorDevTestTask.model.utils.BaseItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ITEM")
public class Dvd extends BaseItem {
    @Column(name = "size") // in mb
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
