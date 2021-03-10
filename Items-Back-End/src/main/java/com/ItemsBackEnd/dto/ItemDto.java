package com.ItemsBackEnd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ItemDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String sku;

    @NotEmpty(message = "Please enter product name...")
    @NotBlank(message = "Please fill product name...")
    @JsonProperty
    private String name;

    @NotEmpty(message = "Please enter product price...")
    @JsonProperty
    private Long price;

    @NotEmpty(message = "Please enter product property...")
    @JsonProperty
    private String property;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
