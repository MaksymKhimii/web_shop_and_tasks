package com.epam.khimii.task4.reflection;

import com.epam.khimii.task1.entity.Accessory;
import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.GraphicsCard;
import com.epam.khimii.task1.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductClassesContainer {
    private final Map<Integer, Class<? extends Product>> classes = new HashMap<>();

    public ProductClassesContainer() {
        classes.put(1, Product.class);
        classes.put(2, Accessory.class);
        classes.put(3, ComputerPart.class);
        classes.put(4, GraphicsCard.class);
    }

    public Class<? extends Product> getClassByCode(int code) {
        if (!classes.containsKey(code)) {
            return Product.class;
        }
        return classes.get(code);
    }

    public Map<Integer, Class<? extends Product>> getClasses() {
        return classes;
    }
}
