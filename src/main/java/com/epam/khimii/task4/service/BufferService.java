package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.repository.IBufferRepository;

public class BufferService implements IBufferService {
    private IBufferRepository bufferRepository;

    public BufferService(IBufferRepository bufferRepository) {
        this.bufferRepository = bufferRepository;
    }

    @Override
    public Buffer getBuffer() {
        return bufferRepository.getBuffer();
    }
}
