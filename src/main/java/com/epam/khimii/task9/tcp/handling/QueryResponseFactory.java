package com.epam.khimii.task9.tcp.handling;

import com.epam.khimii.task1.entity.Product;

import java.util.List;

public class QueryResponseFactory implements ResponseFactory {
    @Override
    public QueryHandler createResponse(String query, List<Product> products) {
        if (query.equals("get count")) {
            return new CountOfProducts(products);
        }
        if (query.contains("get item=")) {
            return new FindProduct(query, products);
        }
        return new DefaultAnswer();
    }
}