package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.impl.BasketRepository;

import java.util.Map;

public class BasketService implements IBasketServiceImpl {
    public BasketRepository basketRepository = new BasketRepository();

    @Override
    public double buyBasket() {
        double totalSum = getBasketSum();
        if (totalSum == -1) {
            return -1;
        }
        basketRepository.clear();
        return totalSum;
    }

    @Override
    public double getBasketSum() {
        if (basketRepository.isEmpty()) {
            return -1;
        }
        double totalSum = 0;
        Map<Double, Integer> basket = basketRepository.getValuesForCalculation();
        for (Map.Entry<Double, Integer> entry : basket.entrySet()) {
            totalSum += entry.getKey() * entry.getValue();
        }
        return totalSum;
    }
}