package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.entity.Buffer;

public class ShowBufferCommand implements Command {
    public static Buffer buffer = new Buffer();

    @Override
    public void execute() {
        System.out.println("Последние 5 товаров: ");
        System.out.println(buffer.toString());
    }
}