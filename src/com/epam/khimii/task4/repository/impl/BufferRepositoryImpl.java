package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.repository.IBufferRepository;

import java.io.Serializable;

public class BufferRepositoryImpl implements IBufferRepository, Serializable {
    private Buffer buffer = new Buffer();

    @Override
    public void put(String key, Integer value) {
        buffer.put(key, value);
    }

    @Override
    public Buffer getBuffer() {
        return buffer;
    }

    @Override
    public void addToBasketBuffer(String name, int quantity) {
        put(name, quantity);
    }
}