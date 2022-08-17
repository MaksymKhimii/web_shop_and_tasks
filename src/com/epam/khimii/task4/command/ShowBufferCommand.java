package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.repository.IBufferRepository;

public class ShowBufferCommand implements Command {
    private IBufferRepository bufferRepository;

    public ShowBufferCommand(IBufferRepository bufferRepository) {
        this.bufferRepository = bufferRepository;
    }

    @Override
    public void execute() {
        System.out.println("Last 5 products in buffer: ");
        Utils.printBuffer(bufferRepository.getBuffer());
    }
}