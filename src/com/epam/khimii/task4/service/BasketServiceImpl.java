package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;

import java.util.Map;

public class BasketServiceImpl implements IBasketService {
    private BasketRepositoryImpl basketRepositoryImpl;

    public BasketServiceImpl(BasketRepositoryImpl basketRepositoryImpl) {
        this.basketRepositoryImpl = basketRepositoryImpl;
    }

    @Override
    public double buyBasket() {
        double totalSum = getBasketSum();
        if (totalSum == -1) {
            return -1;
        }
        basketRepositoryImpl.clear();
        return totalSum;
    }

    @Override
    public double getBasketSum() {
        if (basketRepositoryImpl.isEmpty()) {
            return -1;
        }
        double totalSum = 0;
        Map<Double, Integer> basket = basketRepositoryImpl.getValuesForCalculation();
        for (Map.Entry<Double, Integer> entry : basket.entrySet()) {
            totalSum += entry.getKey() * entry.getValue();
        }
        return totalSum;
    }
}