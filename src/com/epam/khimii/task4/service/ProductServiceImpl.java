package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;

public class ProductServiceImpl implements IProductService {
    private ProductRepositoryImpl productRepository;

    public ProductServiceImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void productInit() {
        productRepository.addAll();
    }
}
