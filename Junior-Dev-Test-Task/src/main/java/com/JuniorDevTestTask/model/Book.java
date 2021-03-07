package com.JuniorDevTestTask.model;

import com.JuniorDevTestTask.model.utils.BaseItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ITEM")
public class Book extends BaseItem {
    @Column(name = "weight")
    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
