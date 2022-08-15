package com.epam.khimii.task4.repository;

import com.epam.khimii.task4.entity.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product p);

    List<Product> getProducts();
}
