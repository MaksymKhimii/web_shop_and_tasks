package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private List<Product> products = new ArrayList<>();
    private static final Product product1 = new Product("apple", 11.0, "uk");
    private static final Product product2 = new Product("banana", 12.0, "uk");
    private static final Product product3 = new Product("potato", 13.0, "uk");
    private static final Product product4 = new Product("tomato", 14.0, "uk");
    private static final Product product5 = new Product("peach", 15.0, "uk");
    private static final Product product6 = new Product("olive", 16.0, "ua");

    @Override
    public void add(Product p) {
        products.add(p);
    }

    public boolean isExists(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addAll() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}