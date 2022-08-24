package com.epam.khimii.task4.strategy;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public interface InputProductStrategy {
    Product generateProduct(List<Product> products);

    int getType();
}
