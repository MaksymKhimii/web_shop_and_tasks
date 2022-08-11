package com.epam.khimii.task4.repository.impl;


import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.repository.IBufferRepository;

import java.util.Map;

public class BufferRepositoryImpl implements IBufferRepository {
    private static final Buffer buffer = new Buffer();

    public String getFirstInBuffer() {
        for (Map.Entry<String, Integer> entry : buffer.entrySet()) {
            return entry.getKey();
        }
        return null;
    }

    @Override
    public void addToBasketBuffer(String name, int quantity) {
        if (buffer.size() == 3) {
            buffer.remove(getFirstInBuffer());
        }
        buffer.put(name, quantity);
    }
}
