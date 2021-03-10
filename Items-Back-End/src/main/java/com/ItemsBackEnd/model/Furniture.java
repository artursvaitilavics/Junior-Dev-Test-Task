package com.ItemsBackEnd.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FURNITURE")
public class Furniture extends Item{

}
