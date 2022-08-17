package com.epam.khimii.task4.command;

import com.epam.khimii.task4.repository.IOrderRepository;

import java.time.LocalDateTime;

public class DoOrderCommand implements Command {
    private final IOrderRepository orderRepositoryImpl;

    public DoOrderCommand(IOrderRepository orderRepositoryImpl) {
        this.orderRepositoryImpl = orderRepositoryImpl;
    }

    @Override
    public void execute() {
        LocalDateTime date = LocalDateTime.now();
        orderRepositoryImpl.doOrder(date);
        System.out.println("Current time: " + date);
    }
}