package com.epam.khimii.task1.entity;
import com.epam.khimii.task4.fieldAnnotaions.FieldTittle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable {

    @FieldTittle(title = "name")
    private String name;

    @FieldTittle(title = "price")
    private BigDecimal price;

    @FieldTittle(title = "country")
    private String country;

    public Product(){
    }

    public Product(String name, BigDecimal price, String country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(country, product.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.price, this.country);
    }
}
