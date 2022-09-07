package com.epam.khimii.task1.entity;


import com.epam.khimii.task4.fieldAnnotaions.FieldTittle;

import java.math.BigDecimal;
import java.util.Objects;

public class Accessory extends Product {

    @FieldTittle(title = "type")
    private String type;

    @FieldTittle(title = "brand")
    private String brand;

    public Accessory() {
    }


    public Accessory(String name, BigDecimal price, String country, String type, String brand) {
        super(name, price, country);
        this.type = type;
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Accessories{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Accessory that = (Accessory) o;
        return Objects.equals(type, that.type) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, brand);
    }
}
