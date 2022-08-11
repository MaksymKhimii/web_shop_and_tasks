package com.epam.khimii.task4.repository;

public interface IBasketRepository {
    void addToBasket(String name, int quantity);

    double getBasketSum();
}
