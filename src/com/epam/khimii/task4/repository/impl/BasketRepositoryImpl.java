package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.repository.IBasketRepository;

import java.util.Map;

public class BasketRepositoryImpl implements IBasketRepository {
    public static final Basket basket = new Basket();
    BufferRepositoryImpl bufferRepositoryImpl = new BufferRepositoryImpl();
    ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();

    public static int size() {
        return basket.size();
    }

    public static boolean isEmpty() {
        return basket.isEmpty();
    }

    public static void clear() {
        basket.clear();
    }

    @Override
    public void addToBasket(String name, int quantity) {
        basket.put(name, quantity);
        bufferRepositoryImpl.addToBasketBuffer(name, quantity);
    }

    @Override
    public double getBasketSum() {
        if (basket.isEmpty()) {
            return -1;
        }
        double totalSum = 0;
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            if (ProductRepositoryImpl.isExists(name)) {
                totalSum += quantity * productRepositoryImpl.getProductPrice(name);
            }
        }
        return totalSum;
    }
}
