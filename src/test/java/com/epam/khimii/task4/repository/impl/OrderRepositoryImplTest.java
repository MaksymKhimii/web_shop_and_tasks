package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImplTest {
    ApplicationContext applicationContext = new ApplicationContext();
    Product product1, product2, product3, product4, product5, product6;
    public Basket basket;
    public Buffer buffer;
    ProductRepositoryImpl productRepository;
    BasketRepositoryImpl basketRepositoryImpl;
    public static OrderRepositoryImpl orderRepositoryImpl;
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
        orderRepositoryImpl = new OrderRepositoryImpl(basketRepositoryImpl.getBasket());
        applicationContext.initAll();
    }

    @Test
    public void doOrderTest() {
        basketRepositoryImpl.addToBasket(product2.getName(), 11);
        basketRepositoryImpl.addToBasket(product4.getName(), 2);
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        Optional<Order> order = orderRepositoryImpl.getOrderByTime(date);
        Assert.assertEquals("Optional[Order{date=" + date + ", " +
                "order={" + product2.getName() + "=11, " + product4.getName() + "=2}}]", order.toString());
        basket.clear();
    }

    @Test
    public void showOrderByTimeRangeTest() {
        basketRepositoryImpl.addToBasket(product1.getName(), 1);
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        List<Order> actual = orderRepositoryImpl.getOrderByRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        Assert.assertEquals("[Order{date=" + date + ", order={" + product1.getName() + "=1}}]", actual.toString());
        basket.clear();
    }

    @Test
    public void showOrderByTimeTest() {
        basketRepositoryImpl.addToBasket(product2.getName(), 17);
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        Optional<Order> actual = orderRepositoryImpl.getOrderByTime(date);
        Assert.assertEquals("Optional[Order{date=" + date + ", order={" + product2.getName() + "=17}}]", actual.toString());
        basket.clear();
    }
}
