package com.epam.khimii.task7.proxy.products;

import java.math.BigDecimal;

public class ProductImpl implements IProduct {
    private String name;
    private BigDecimal price;
    private String country;

    public ProductImpl(String name, BigDecimal price, String country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Product{name='" + this.name + "', price='" + this.price + "', country='" + this.country + "'}";
    }
}
