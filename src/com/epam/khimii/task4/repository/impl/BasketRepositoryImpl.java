package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.entity.Basket;

import com.epam.khimii.task4.repository.IBasketRepository;
import com.epam.khimii.task4.repository.IBufferRepository;
import com.epam.khimii.task4.repository.IProductRepository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.epam.khimii.task4.entity.Basket.isExists;

public class BasketRepositoryImpl implements IBasketRepository, Serializable {
    private Basket basket = new Basket();
    private IBufferRepository bufferRepositoryImpl;
    private IProductRepository productRepositoryImpl;

    public BasketRepositoryImpl(IProductRepository productRepositoryImpl, IBufferRepository bufferRepositoryImpl) {
        this.productRepositoryImpl = productRepositoryImpl;
        this.bufferRepositoryImpl = bufferRepositoryImpl;
    }

    @Override
    public Basket getBasket() {
        return basket;
    }

    public int size() {
        return basket.size();
    }

    @Override
    public boolean isEmpty() {
        return basket.isEmpty();
    }

    @Override
    public void clear() {
        basket.clear();
    }

    public void put(String key, Integer value) {
        if (isExists(key)) {
            int newValue = basket.get(key) + value;
            basket.put(key, newValue);
            bufferRepositoryImpl.addToBasketBuffer(key, newValue);
            return;
        }
        basket.put(key, value);
        bufferRepositoryImpl.addToBasketBuffer(key, value);
    }

    @Override
    public void addToBasket(String name, int quantity) {
        put(name, quantity);
        bufferRepositoryImpl.addToBasketBuffer(name, quantity);
    }

    @Override
    public Map<Double, Integer> getValuesForCalculation() {
        Map<Double, Integer> forCalculation = new HashMap<>();
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            String prodInBasket = entry.getKey();
            int quantity = entry.getValue();
            for (Product product : productRepositoryImpl.getProducts()) {
                if (product.getName().equals(prodInBasket)) {
                    forCalculation.put(product.getPrice().doubleValue(), quantity);
                }
            }
        }
        return forCalculation;
    }
}