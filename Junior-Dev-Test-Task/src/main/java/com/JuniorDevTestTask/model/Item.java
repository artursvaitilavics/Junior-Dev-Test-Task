package com.JuniorDevTestTask.model;

import com.JuniorDevTestTask.model.utils.BaseItem;

import javax.persistence.*;

@Entity
@Table(name = "product_item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "item_type")
public class Item extends BaseItem {


}
