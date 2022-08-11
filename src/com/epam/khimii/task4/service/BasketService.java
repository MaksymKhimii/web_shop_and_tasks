package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;

public class BasketService {
    public static BasketRepositoryImpl basketRepository = new BasketRepositoryImpl();

    public static String buyBasket() {
        double totalSum = basketRepository.getBasketSum();
        if (totalSum == -1) {
            return "Basket is empty, you can't buy it";
        }
        BasketRepositoryImpl.clear();
        return "The total amount of the order: " + totalSum;
    }
}