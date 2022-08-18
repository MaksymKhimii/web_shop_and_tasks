package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.IProductRepository;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isProduct(String name) {
        return productRepository.isExists(name);
    }

    @Override
    public void productInit(List<Product> products) {
        productRepository.addAll(products);
    }
}
