package com.JuniorDevTestTask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String sku;

    @JsonProperty
    private String name;

    @JsonProperty
    private Long price;

    @JsonProperty
    private String type;

    @JsonProperty
    private String property;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
