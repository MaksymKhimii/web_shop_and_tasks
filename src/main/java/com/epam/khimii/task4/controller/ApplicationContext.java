package com.epam.khimii.task4.controller;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.container.FillStrategyContainer;
import com.epam.khimii.task4.fileHandler.FileHandler;
import com.epam.khimii.task4.reflection.InputWithReflection;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationContext {
    private static final Product product1 = new Product("apple", new BigDecimal(11.0), "uk");
    private static final Product product2 = new Product("banana", new BigDecimal(12.0), "uk");
    private static final Product product3 = new Product("potato", new BigDecimal(13.0), "uk");
    private static final Product product4 = new Product("tomato", new BigDecimal(14.0), "uk");
    private static final Product product5 = new Product("peach", new BigDecimal(15.0), "uk");
    private static final Product product6 = new Product("olive", new BigDecimal(16.0), "ua");
    private IProductRepository productRepositoryImpl;
    private IBasketRepository basketRepositoryImpl;
    private IBufferRepository bufferRepositoryImpl;
    private IOrderRepository orderRepositoryImpl;
    private IBasketService basketServiceImpl;
    private IOrderService orderServiceImpl;
    private IProductService productService;
    private IBufferService bufferService;
    private FileHandler fileHandler;
    private FillStrategyContainer fillStrategyContainer;
    private InputWithReflection inputWithReflection;
    private Scanner scanner = new Scanner(System.in);

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
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

    public FileHandler getProductContainerFilesHandler() {
        return fileHandler;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public FillStrategyContainer getFillStrategyContainer() {
        return fillStrategyContainer;
    }

    public InputWithReflection getInputAppWithReflection() {
        return inputWithReflection;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void initAll() {
        this.productRepositoryImpl = new ProductRepositoryImpl();
        this.productService = new ProductServiceImpl(productRepositoryImpl);
        this.fileHandler = new FileHandler();
        products = fileHandler.load();
        if (products.isEmpty()) {
            products.add(product1);
            products.add(product2);
            products.add(product3);
            products.add(product4);
            products.add(product5);
            products.add(product6);
        }
        productService.productInit(products);
        this.fillStrategyContainer = new FillStrategyContainer(scanner);
        this.bufferRepositoryImpl = new BufferRepositoryImpl();
        this.basketRepositoryImpl = new BasketRepositoryImpl(productRepositoryImpl, bufferRepositoryImpl);
        this.orderRepositoryImpl = new OrderRepositoryImpl(basketRepositoryImpl.getBasket());
        this.orderServiceImpl = new OrderServiceImpl(orderRepositoryImpl);
        this.basketServiceImpl = new BasketServiceImpl(basketRepositoryImpl);
        this.bufferService = new BufferService(bufferRepositoryImpl);
        this.inputWithReflection = new InputWithReflection();
    }
}