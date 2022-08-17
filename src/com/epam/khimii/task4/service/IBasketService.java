package com.epam.khimii.task4.service;

public interface IBasketService {
    void addToBasket(String name, int quantity);

    double getBasketSum();
}
