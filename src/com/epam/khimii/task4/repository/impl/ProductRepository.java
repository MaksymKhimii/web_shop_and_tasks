package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.IProductRepositoryImpl;

import java.util.List;

public class ProductRepository implements IProductRepositoryImpl {
    private List<Product> products;
    private ApplicationContext applicationContext = new ApplicationContext();

    public ProductRepository() {
        this.products = applicationContext.getProducts();
    }

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
}