package com.epam.khimii.task4.service;


import com.epam.khimii.task1.entity.Product;

import java.util.List;

public interface IProductService {
    boolean isProduct(String name);

    void productInit(List<Product> products);

    void addProdToList(Product product);

    boolean isExists(Product product);
}
