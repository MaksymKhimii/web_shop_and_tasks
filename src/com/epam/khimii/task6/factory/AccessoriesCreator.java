package com.epam.khimii.task6.factory;

import com.epam.khimii.task1.entity.Accessory;
import com.epam.khimii.task1.entity.Product;

public class AccessoriesCreator extends ProductCreator {
    @Override
    public Product createProductFromString(String line) {
        Product p = super.createProductFromString(line);
        return new Accessory(p.getName(), p.getPrice(), p.getCountry(), this.getField(this.matcher), this.getField(this.matcher));
    }
}
