package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Product;
import com.epam.khimii.task4.repository.IBasketRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.khimii.task4.entity.Basket.isExists;

public class BasketRepository implements IBasketRepositoryImpl {
    ApplicationContext applicationContext = new ApplicationContext();
    private Basket basket = new Basket();
    List<Product> products = applicationContext.getProducts();
    BufferRepository bufferRepository = new BufferRepository();

    public int size() {
        return basket.size();
    }

    public boolean isEmpty() {
        return basket.isEmpty();
    }

    public void clear() {
        basket.clear();
    }

    public void put(String key, Integer value) {
        if (isExists(key)) {
            int newValue = basket.get(key) + value;
            basket.put(key, newValue);
            return;
        }
        basket.put(key, value);
    }

    @Override
    public void addToBasket(String name, int quantity) {
        put(name, quantity);
        bufferRepository.addToBasketBuffer(name, quantity);
    }

    public Map<Double, Integer> getValuesForCalculation() {
        Map<Double, Integer> forCalculation = new HashMap<>();
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            String prodInBasket = entry.getKey();
            int quantity = entry.getValue();
            for (Product product : products) {
                if (product.getName().equals(prodInBasket)) {
                    forCalculation.put(product.getPrice(), quantity);
                }
            }
        }
        return forCalculation;
    }
}
