package com.epam.khimii.task9.http;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task9.ProductLoader;
import com.epam.khimii.task9.http.factory.QueryProcessCreator;
import com.epam.khimii.task9.http.factory.QueryResponseFactory;
import org.junit.Assert;
import org.junit.Test;
import java.net.URI;
import java.util.List;

public class HttpServerTest {
    private static final QueryResponseFactory responseFactory = new QueryResponseFactory();
    private static final List<Product> products = ProductLoader.load();
    private URI requestURI;
    private String response;

    @Test
    public void countQueryTest() {
        requestURI = URI.create("/shop/count");
        QueryProcessCreator queryProcessCreator = responseFactory.createResponse(requestURI);
        response = queryProcessCreator.processQuery(products);
        Assert.assertEquals("{count:" + products.size() + "}", response);
    }

    @Test
    public void getItemFromProductsQueryTest() {
        requestURI = URI.create("/shop/item?get_info=apple");
        QueryProcessCreator queryProcessCreator = responseFactory.createResponse(requestURI);
        response = queryProcessCreator.processQuery(products);
        Product expected = products.get(0);
        Assert.assertEquals("{name: " + expected.getName() + ", price: " + expected.getPrice() + "}", response);
    }

    @Test
    public void getNonExistentItemFromProductsQueryTest() {
        requestURI = URI.create("/shop/item?get_info=pineapple");
        QueryProcessCreator queryProcessCreator = responseFactory.createResponse(requestURI);
        response = queryProcessCreator.processQuery(products);
        Assert.assertEquals("Product with this name was not found(", response);
    }

    @Test
    public void defaultQueryResponseTest() {
        requestURI = URI.create("/shop/lalalal");
        QueryProcessCreator queryProcessCreator = responseFactory.createResponse(requestURI);
        response = queryProcessCreator.processQuery(products);
        Assert.assertEquals("Path or query is not valid", response);
    }
}