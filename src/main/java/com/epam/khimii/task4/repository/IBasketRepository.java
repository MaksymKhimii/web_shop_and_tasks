package com.epam.khimii.task4.repository;

import com.epam.khimii.task4.entity.Basket;

import java.util.Map;

public interface IBasketRepository {
    void addToBasket(String name, int quantity);

    Map<Double, Integer> getValuesForCalculation();

    void clear();

    boolean isEmpty();

    Basket getBasket();
}
