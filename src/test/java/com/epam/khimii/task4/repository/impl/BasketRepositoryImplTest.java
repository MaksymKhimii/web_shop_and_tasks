package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BasketRepositoryImplTest {
    ApplicationContext applicationContext = new ApplicationContext();
    Product product1, product2, product3, product4, product5, product6;
    public Basket basket;
    public Buffer buffer;
    ProductRepositoryImpl productRepository;
    BasketRepositoryImpl basketRepositoryImpl;
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
        applicationContext.initAll();
    }

    @Test
    public void addToBasketTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        Assert.assertEquals(2, basketRepositoryImpl.size());
        basket.clear();
    }


    @Test
    public void showBasketTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        Assert.assertEquals("""
                Product{name='apple', quantity='1'}\r
                Product{name='potato', quantity='12'}\r
                """, basket.toString());
        basket.clear();
    }

    @Test
    public void showBufferTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        basketRepositoryImpl.addToBasket(product3.getName(), 12);
        basketRepositoryImpl.addToBasket(product2.getName(), 11);
        basketRepositoryImpl.addToBasket(product4.getName(), 12);
        basketRepositoryImpl.addToBasket(product5.getName(), 7);
        basketRepositoryImpl.addToBasket(product6.getName(), 99);
        Assert.assertEquals("""
                Product{name='potato', quantity='12'}\r
                Product{name='banana', quantity='11'}\r
                Product{name='tomato', quantity='12'}\r
                Product{name='peach', quantity='7'}\r
                Product{name='olive', quantity='99'}\r
                """, buffer.toString());
        basket.clear();
    }
}