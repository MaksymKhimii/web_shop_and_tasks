package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.service.IBufferService;

public class ShowBufferCommand implements Command {
    private IBufferService bufferService;

    public ShowBufferCommand(IBufferService bufferService) {
        this.bufferService = bufferService;
    }

    @Override
    public void execute() {
        System.out.println("Last 5 products in buffer: ");
        Utils.printBuffer(bufferService.getBuffer());
    }
}