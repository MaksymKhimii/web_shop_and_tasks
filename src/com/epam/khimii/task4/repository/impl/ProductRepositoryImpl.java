package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Product2;
import com.epam.khimii.task4.repository.IProductRepository;

import java.util.ArrayList;

public class ProductRepositoryImpl implements IProductRepository {
    private static final Product2 product1 = new Product2("apple", 11.0, "uk");
    private static final Product2 product2 = new Product2("banana", 12.0, "uk");
    private static final Product2 product3 = new Product2("potato", 13.0, "uk");
    private static final Product2 product4 = new Product2("tomato", 14.0, "uk");
    public static ArrayList<Product2> products = new ArrayList<>();

    public static void add(Product2 p) {
        products.add(p);
    }

    public static void initProduct() {
        add(product1);
        add(product2);
        add(product3);
        add(product4);
    }

    public static boolean isExists(String name) {
        for (Product2 product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getProductPrice(String name) {
        for (Product2 product : products) {
            if (product.getName().equals(name)) {
                return product.getPrice();
            }
        }
        return -1;
    }
}