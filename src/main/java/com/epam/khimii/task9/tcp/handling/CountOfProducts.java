package com.epam.khimii.task9.tcp.handling;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public class CountOfProducts implements QueryHandler {
    private final List<Product> products;

    public CountOfProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String processQuery() {
        return String.valueOf(products.size());
    }
}