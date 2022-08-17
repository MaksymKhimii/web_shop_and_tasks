package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.IBasketRepository;
import com.epam.khimii.task4.repository.IBufferRepository;
import com.epam.khimii.task4.repository.IOrderRepository;
import com.epam.khimii.task4.repository.IProductRepository;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.BufferRepositoryImpl;
import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;
import com.epam.khimii.task4.service.BasketServiceImpl;
import com.epam.khimii.task4.service.BufferService;
import com.epam.khimii.task4.service.IBasketService;
import com.epam.khimii.task4.service.IBufferService;
import com.epam.khimii.task4.service.IOrderService;
import com.epam.khimii.task4.service.IProductService;
import com.epam.khimii.task4.service.OrderServiceImpl;
import com.epam.khimii.task4.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationContext {
    private static final Product product1 = new Product("apple", 11.0, "uk");
    private static final Product product2 = new Product("banana", 12.0, "uk");
    private static final Product product3 = new Product("potato", 13.0, "uk");
    private static final Product product4 = new Product("tomato", 14.0, "uk");
    private static final Product product5 = new Product("peach", 15.0, "uk");
    private static final Product product6 = new Product("olive", 16.0, "ua");
    private Scanner scanner = new Scanner(System.in);
    private IProductRepository productRepositoryImpl;
    private IBasketRepository basketRepositoryImpl;
    private IBufferRepository bufferRepositoryImpl;
    private IOrderRepository orderRepositoryImpl;
    private IBasketService basketServiceImpl;
    private IOrderService orderServiceImpl;
    private IProductService productService;
    private IBufferService bufferService;

    private final List<Product> products = new ArrayList<>() {{
        add(product1);
        add(product2);
        add(product3);
        add(product4);
        add(product5);
        add(product6);
    }};

    public Scanner getScanner() {
        return scanner;
    }

    public IProductRepository getProductRepositoryImpl() {
        return productRepositoryImpl;
    }

    public IBasketRepository getBasketRepositoryImpl() {
        return basketRepositoryImpl;
    }

    public IBufferRepository getBufferRepositoryImpl() {
        return bufferRepositoryImpl;
    }

    public IOrderRepository getOrderRepositoryImpl() {
        return orderRepositoryImpl;
    }

    public IBasketService getBasketServiceImpl() {
        return basketServiceImpl;
    }

    public IOrderService getOrderServiceImpl() {
        return orderServiceImpl;
    }

    public IProductService getProductService() {
        return productService;
    }

    public IBufferService getBufferService() {
        return bufferService;
    }

    public void initAll() {
        this.productRepositoryImpl = new ProductRepositoryImpl();
        this.productService = new ProductServiceImpl(productRepositoryImpl);
        productService.productInit(products);
        this.bufferRepositoryImpl = new BufferRepositoryImpl();
        this.basketRepositoryImpl = new BasketRepositoryImpl(productRepositoryImpl, bufferRepositoryImpl);
        this.orderRepositoryImpl = new OrderRepositoryImpl(basketRepositoryImpl.getBasket());
        this.orderServiceImpl = new OrderServiceImpl(orderRepositoryImpl);
        this.basketServiceImpl = new BasketServiceImpl(basketRepositoryImpl);
        this.bufferService = new BufferService(bufferRepositoryImpl);
    }
}
