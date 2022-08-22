package com.epam.khimii.task6.fill_product_strategy;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;

public interface FillProductDataStrategy {
    UniqueProductArrayList<Product> fill(int var1);

}
