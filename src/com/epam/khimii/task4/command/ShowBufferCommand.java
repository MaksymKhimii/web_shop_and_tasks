package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.repository.impl.BufferRepositoryImpl;

public class ShowBufferCommand implements Command {
    BufferRepositoryImpl bufferRepository;

    public ShowBufferCommand(BufferRepositoryImpl bufferRepository) {
        this.bufferRepository = bufferRepository;
    }

    @Override
    public void execute() {
        System.out.println("Last 5 products in buffer: ");
        Utils.printBuffer(bufferRepository.getBuffer());
    }
}