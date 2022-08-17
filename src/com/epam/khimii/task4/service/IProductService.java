package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Product;

import java.util.List;

public interface IProductService {
    boolean isProduct(String name);

    void productInit(List<Product> products);
}
