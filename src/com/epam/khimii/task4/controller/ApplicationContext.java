package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.BufferRepositoryImpl;
import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;
import com.epam.khimii.task4.service.BasketServiceImpl;
import com.epam.khimii.task4.service.OrderServiceImpl;
import com.epam.khimii.task4.service.ProductServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ApplicationContext {
    private static final Scanner scanner = new Scanner(System.in);
    private ProductRepositoryImpl productRepositoryImpl;
    private BasketRepositoryImpl basketRepositoryImpl;
    private BufferRepositoryImpl bufferRepositoryImpl;
    private OrderRepositoryImpl orderRepositoryImpl;
    private BasketServiceImpl basketServiceImpl;
    private OrderServiceImpl orderServiceImpl;
    private ProductServiceImpl productService;
    private List<Product> products;

    public ProductRepositoryImpl getProductRepository() {
        return productRepositoryImpl;
    }

    public BasketRepositoryImpl getBasketRepository() {
        return basketRepositoryImpl;
    }

    public BufferRepositoryImpl getBufferRepository() {
        return bufferRepositoryImpl;
    }

    public OrderRepositoryImpl getOrderRepository() {
        return orderRepositoryImpl;
    }

    public BasketServiceImpl getBasketService() {
        return basketServiceImpl;
    }

    public OrderServiceImpl getOrderService() {
        return orderServiceImpl;
    }

    public void initAll() {
        this.productRepositoryImpl = new ProductRepositoryImpl();
        productRepositoryImpl.addAll();
        products = productRepositoryImpl.getProducts();
        this.productService = new ProductServiceImpl(productRepositoryImpl);
        productService.productInit();
        this.bufferRepositoryImpl = new BufferRepositoryImpl();
        this.basketRepositoryImpl = new BasketRepositoryImpl(bufferRepositoryImpl, products);
        this.orderRepositoryImpl = new OrderRepositoryImpl(basketRepositoryImpl.getBasket());
        this.orderServiceImpl = new OrderServiceImpl(orderRepositoryImpl);
        this.basketServiceImpl = new BasketServiceImpl(basketRepositoryImpl);
    }

    public LocalDateTime getTime() {
        return LocalDateTime.parse(scanner.nextLine());
    }
}
