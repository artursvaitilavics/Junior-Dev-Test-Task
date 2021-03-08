package com.JuniorDevTestTask.model;

import com.JuniorDevTestTask.model.utils.BaseItem;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "PRODUCT_ITEM")
public class Item extends BaseItem {
}
