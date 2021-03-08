package com.JuniorDevTestTask.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DVD")
public class Dvd extends Item{

}
