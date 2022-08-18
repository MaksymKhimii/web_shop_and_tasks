package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product p) {
        products.add(p);
    }

    @Override
    public boolean isExists(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addAll(List<Product> newProducts) {
        products.addAll(newProducts);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}