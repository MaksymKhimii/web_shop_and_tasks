package com.epam.khimii.task9.tcp.handling;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public interface ResponseFactory {
    QueryHandler createResponse(String query, List<Product> products);
}