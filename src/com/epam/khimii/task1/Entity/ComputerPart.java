package com.epam.khimii.task1.Entity;

import java.math.BigDecimal;
import java.util.Objects;

public class ComputerPart extends Product{

    private String category;
    private String purpose;

    ComputerPart(){
    }

    public ComputerPart(String name, BigDecimal price, String country, String category, String purpose) {
        super(name, price, country);
        this.category = category;
        this.purpose = purpose;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "ComputerPart{" +
                "category='" + category + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComputerPart that = (ComputerPart) o;
        return Objects.equals(category, that.category) && Objects.equals(purpose, that.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, purpose);
    }
}
