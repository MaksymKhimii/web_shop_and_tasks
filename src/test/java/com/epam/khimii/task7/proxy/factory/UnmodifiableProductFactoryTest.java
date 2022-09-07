package com.epam.khimii.task7.proxy.factory;

import com.epam.khimii.task7.proxy.products.IProduct;
import com.epam.khimii.task7.proxy.products.ProductImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class UnmodifiableProductFactoryTest {
    private UnmodifiableProductFactory unmodifiableProductFactory;
    private IProduct product;
    private String result;

    @Before
    public void beforeTest() {
        unmodifiableProductFactory = new UnmodifiableProductFactory();
        product = new ProductImpl("test1", new BigDecimal(1), "test1");
        result = product.toString();
    }

    @Test
    public void UnmodifiableProductCreatorTest() {
        IProduct actual = unmodifiableProductFactory.createProxyProduct(product);
        Assert.assertEquals(result, actual.toString());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotSetPrice() {
        IProduct result = unmodifiableProductFactory.createProxyProduct(product);
        result.setPrice(new BigDecimal(11));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotSetName() {
        IProduct result = unmodifiableProductFactory.createProxyProduct(product);
        result.setName("test2");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotSetCountry() {
        IProduct result = unmodifiableProductFactory.createProxyProduct(product);
        result.setCountry("UK");
    }
}