package com.epam.khimii.task9.http.factory;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public class GetProductQuery implements QueryProcessCreator {
    private final String query;

    public GetProductQuery(String query) {
        this.query = query;
    }

    @Override
    public String processQuery(List<Product> products) {
        String neededProductName = query.replaceAll("get_info=", "");
        for (Product p : products) {
            if (p.getName().equals(neededProductName)) {
                return "{name: " + p.getName() + ", price: " + p.getPrice() + "}";
            }
        }
        return "Product with this name was not found(";
    }
}