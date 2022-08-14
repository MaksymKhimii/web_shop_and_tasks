package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;

public class ShowBufferCommand implements Command {
    Utils utils = new Utils();

    @Override
    public void execute() {
        System.out.println("Last 5 products in buffer: ");
        utils.printBuffer();
    }
}