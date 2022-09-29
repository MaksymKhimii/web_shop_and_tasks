package com.epam.khimii.task9.tcp.handling;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public class FindProduct implements QueryHandler {
    private final List<Product> products;
    private final String query;

    public FindProduct(String query, List<Product> products) {
        this.query = query;
        this.products = products;
    }

    @Override
    public String processQuery() {
        String neededProductName = query.replaceAll("get item=", "");
        for (Product p : products) {
            if (p.getName().equals(neededProductName)) {
                return p.getName() + " | " + p.getPrice();
            }
        }
        return "Product with this name was not found(";
    }
}