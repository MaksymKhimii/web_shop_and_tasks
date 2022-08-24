package com.epam.khimii.task4.service;


import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.repository.IProductRepository;

import java.io.Serializable;
import java.util.List;

public class ProductServiceImpl implements IProductService, Serializable {
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

    @Override
    public void addProdToList(Product product) {
        productRepository.add(product);
    }

    @Override
    public boolean isExists(Product product){
        return productRepository.isExists(product.getName());
    }
}
