package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;

import java.time.LocalDateTime;

public class DoOrderCommand implements Command {
    public static OrderRepositoryImpl orderRepositoryImpl = new OrderRepositoryImpl();

    @Override
    public void execute() {
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        System.out.println("Текущее время: " + date);
    }
}