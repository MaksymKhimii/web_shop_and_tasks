package com.epam.khimii.task4.repository;

public interface IBufferRepository {
    void addToBasketBuffer(String name, int quantity);

    String getFirstInBuffer();
}
