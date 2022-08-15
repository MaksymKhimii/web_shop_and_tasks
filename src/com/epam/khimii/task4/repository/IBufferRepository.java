package com.epam.khimii.task4.repository;

import com.epam.khimii.task4.entity.Buffer;

public interface IBufferRepository {
    void addToBasketBuffer(String name, int quantity);

    Buffer getBuffer();
}
