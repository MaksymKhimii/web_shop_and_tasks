package com.epam.khimii.task4.repository;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product p);

    List<Product> getProducts();

    void addAll(List<Product> products);

    boolean isExists(String name);
}
