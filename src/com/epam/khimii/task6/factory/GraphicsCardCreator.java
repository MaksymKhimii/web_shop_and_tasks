package com.epam.khimii.task6.factory;

import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.GraphicsCard;
import com.epam.khimii.task1.entity.Product;

public class GraphicsCardCreator extends ComputerPartCreator {
    @Override
    public Product createProductFromString(String line) {
        ComputerPart p = (ComputerPart) super.createProductFromString(line);
        return new GraphicsCard(p.getName(), p.getPrice(), p.getCountry(), p.getCategory(), p.getPurpose(), Integer.parseInt(this.getField(this.matcher)), this.getField(this.matcher), this.getField(this.matcher));
    }
}

