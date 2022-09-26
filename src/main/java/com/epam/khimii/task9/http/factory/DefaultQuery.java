package com.epam.khimii.task9.http.factory;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public class DefaultQuery implements QueryProcessCreator {
    @Override
    public String processQuery(List<Product> products) {
        return "Path or query is not valid";
    }
}