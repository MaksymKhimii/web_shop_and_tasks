package com.epam.khimii.task4.entity;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private String country;

    public Product(String name, double price, String country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
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
