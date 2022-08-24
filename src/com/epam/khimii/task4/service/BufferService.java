package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.repository.IBufferRepository;

import java.io.Serializable;

public class BufferService implements IBufferService, Serializable {
    private IBufferRepository bufferRepository;

    public BufferService(IBufferRepository bufferRepository) {
        this.bufferRepository = bufferRepository;
    }

    @Override
    public Buffer getBuffer() {
        return bufferRepository.getBuffer();
    }
}
