package com.epam.khimii.task9.http.factory;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public interface QueryProcessCreator {
    String processQuery(List<Product> products);
}