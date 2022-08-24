package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.IBasketRepository;

import java.io.Serializable;
import java.util.Map;

public class BasketServiceImpl implements IBasketService, Serializable {
    private IBasketRepository basketRepositoryImpl;

    public BasketServiceImpl(IBasketRepository basketRepositoryImpl) {
        this.basketRepositoryImpl = basketRepositoryImpl;
    }

    @Override
    public void addToBasket(String name, int quantity) {
        basketRepositoryImpl.addToBasket(name, quantity);
    }

    @Override
    public double buyBasket() {
        if (basketRepositoryImpl.isEmpty()) {
            return -1;
        }
        double totalSum = 0;
        Map<Double, Integer> basket = basketRepositoryImpl.getValuesForCalculation();
        for (Map.Entry<Double, Integer> entry : basket.entrySet()) {
            totalSum += entry.getKey() * entry.getValue();
        }
        basketRepositoryImpl.clear();
        return totalSum;
    }
}