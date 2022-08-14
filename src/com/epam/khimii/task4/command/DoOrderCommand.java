package com.epam.khimii.task4.command;

import com.epam.khimii.task4.repository.impl.OrderRepository;

import java.time.LocalDateTime;

public class DoOrderCommand implements Command {
    private OrderRepository orderRepository = new OrderRepository();

    @Override
    public void execute() {
        LocalDateTime date = LocalDateTime.now();
        orderRepository.doOrder(date);
        System.out.println("Current time: " + date);
    }
}