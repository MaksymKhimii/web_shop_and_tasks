package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.repository.IBufferRepository;
import static com.epam.khimii.task4.entity.Buffer.isExists;

public class BufferRepositoryImpl implements IBufferRepository {
    private Buffer buffer = new Buffer();

    public void put(String key, Integer value) {
        if (isExists(key)) {
            int newValue = buffer.get(key) + value;
            buffer.put(key, newValue);
            return;
        }
        buffer.put(key, value);
    }

    @Override
    public Buffer getBuffer(){
        return buffer;
    }

    @Override
    public void addToBasketBuffer(String name, int quantity) {
        put(name, quantity);
    }
}
