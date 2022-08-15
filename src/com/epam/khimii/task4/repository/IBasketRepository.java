package com.epam.khimii.task4.repository;

import java.util.Map;

public interface IBasketRepository {
    void addToBasket(String name, int quantity);

    Map<Double, Integer> getValuesForCalculation();
}
