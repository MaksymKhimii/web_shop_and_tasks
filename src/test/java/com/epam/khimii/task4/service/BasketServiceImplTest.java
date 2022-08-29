package com.epam.khimii.task4.service;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.BufferRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BasketServiceImplTest {
    ApplicationContext applicationContext = new ApplicationContext();
    Product product1, product2, product3, product4, product5, product6;
    public Basket basket;
    public Buffer buffer;
    ProductRepositoryImpl productRepository;
    BasketRepositoryImpl basketRepositoryImpl;
    BasketServiceImpl basketServiceImpl;
    BufferRepositoryImpl bufferRepository;

    @Before
    public void BeforeTest() {
        product1 = new Product("apple", new BigDecimal("11.0"), "uk");
        product2 = new Product("banana", new BigDecimal("12.0"), "uk");
        product3 = new Product("potato", new BigDecimal("13.0"), "uk");
        product4 = new Product("tomato", new BigDecimal("14.0"), "uk");
        product5 = new Product("peach", new BigDecimal("15.0"), "uk");
        product6 = new Product("olive", new BigDecimal("16.0"), "ua");
        productRepository = new ProductRepositoryImpl();
        basket = new Basket();
        buffer = new Buffer();
        bufferRepository = new BufferRepositoryImpl();
        basketRepositoryImpl = new BasketRepositoryImpl(productRepository, bufferRepository);
        basketServiceImpl = new BasketServiceImpl(basketRepositoryImpl);
        applicationContext.initAll();
    }

    @Test
    public void buyBasketTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        double actual = basketServiceImpl.buyBasket();
        Assert.assertEquals(0, basketRepositoryImpl.size());
        Assert.assertEquals(167.0, actual, 0);
        basket.clear();
    }

    @Test
    public void buyEmptyBasketTest() {
        double actual = basketServiceImpl.buyBasket();
        Assert.assertEquals(0, basketRepositoryImpl.size());
        Assert.assertEquals(-1, actual, 0);
        basket.clear();
    }

}
