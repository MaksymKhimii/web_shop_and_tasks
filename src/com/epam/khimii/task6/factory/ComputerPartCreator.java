package com.epam.khimii.task6.factory;

import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.Product;

public class ComputerPartCreator extends ProductCreator {
    @Override
    public Product createProductFromString(String line) {
        Product p = super.createProductFromString(line);
        return new ComputerPart(p.getName(), p.getPrice(), p.getCountry(), this.getField(this.matcher), this.getField(this.matcher));
    }
}
