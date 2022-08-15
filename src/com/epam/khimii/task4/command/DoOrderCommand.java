package com.epam.khimii.task4.command;

import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;

import java.time.LocalDateTime;

public class DoOrderCommand implements Command {
    private final OrderRepositoryImpl orderRepositoryImpl;

    public DoOrderCommand(OrderRepositoryImpl orderRepositoryImpl) {
        this.orderRepositoryImpl = orderRepositoryImpl;
    }

    @Override
    public void execute() {
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        System.out.println("Current time: " + date);
    }
}