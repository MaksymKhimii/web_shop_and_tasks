package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.impl.BasketRepository;
import com.epam.khimii.task4.repository.impl.BufferRepository;
import com.epam.khimii.task4.repository.impl.OrderRepository;
import com.epam.khimii.task4.repository.impl.ProductRepository;
import com.epam.khimii.task4.service.BasketService;
import com.epam.khimii.task4.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationContext {
    Scanner scanner = new Scanner(System.in);
    private static final Product product1 = new Product("apple", 11.0, "uk");
    private static final Product product2 = new Product("banana", 12.0, "uk");
    private static final Product product3 = new Product("potato", 13.0, "uk");
    private static final Product product4 = new Product("tomato", 14.0, "uk");
    private static final Product product5 = new Product("peach", 15.0, "uk");
    private static final Product product6 = new Product("olive", 16.0, "ua");
    private List<Product> products = new ArrayList<>();
    private Basket basket = new Basket();
    private Buffer buffer = new Buffer();
    private Order order = new Order();

    ProductRepository productRepository;
    BasketRepository basketRepository;
    BufferRepository bufferRepository;
    OrderRepository orderRepository;
    BasketService basketService;
    OrderService orderService;

    public Order getOrder() {
        return order;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public List<Product> getProducts() {
        productInit();
        return products;
    }

    public Basket getBasket() {
        return basket;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public BufferRepository getBufferRepository() {
        return bufferRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public BasketService getBasketService() {
        return basketService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void initAll() {
        productInit();
        this.productRepository = new ProductRepository();
        this.basketRepository = new BasketRepository();
        this.bufferRepository = new BufferRepository();
        this.orderRepository = new OrderRepository();
        bufferRepository = new BufferRepository();
        orderService = new OrderService();
    }

    public void productInit() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
    }

    public LocalDateTime getTime() {
        return LocalDateTime.parse(scanner.nextLine());
    }
}
