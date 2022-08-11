package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Product2;

import static com.epam.khimii.task4.repository.impl.ProductRepositoryImpl.products;

public class ProductService {
    public static String printProducts() {
        if (products.isEmpty()) {
            return "There is no products here";
        }
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(string);
        for (Product2 p : products) {
            stringBuilder.append("Product{" + "name='").append(p.getName()).append('\'').append(", quantity='").append(p.getPrice()).append('\'').append('}').append("\r\n");
        }
        return stringBuilder.toString();
    }
}
