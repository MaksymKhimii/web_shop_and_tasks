package com.epam.khimii.task9.http.factory;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public class CountQuery implements QueryProcessCreator {
    @Override
    public String processQuery(List<Product> products) {
        return "{count:" + products.size() + "}";
    }
}