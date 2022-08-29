package com.epam.khimii.task7.proxy.factory;

import com.epam.khimii.task7.proxy.products.IProduct;
import com.epam.khimii.task7.proxy.products.ProductImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductOnMapFactoryTest {
    ProductOnMapFactory productOnMapFactory;
    private IProduct actual;

    @Before
    public void beforeTest() {
        productOnMapFactory = new ProductOnMapFactory();
        actual = productOnMapFactory.createProxyProduct(
                new ProductImpl("testOnMap", new BigDecimal(1), "TestOnMap"));
    }

    @Test
    public void shouldModifyProductName() {
        actual.setName("Test1");
        Assert.assertEquals("Test1", actual.getName());
    }

    @Test
    public void shouldModifyProductPrice() {
        actual.setPrice(new BigDecimal(1111));
        Assert.assertEquals("1111", actual.getPrice().toString());
    }

    @Test
    public void shouldModifyProductCountry() {
        actual.setCountry("Ukraine");
        Assert.assertEquals("Ukraine", actual.getCountry());
    }
}