package com.epam.khimii.task4.command;

import com.epam.khimii.task4.service.IOrderService;

import java.time.LocalDateTime;

public class DoOrderCommand implements Command {
    private final IOrderService orderService;

    public DoOrderCommand(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        LocalDateTime date = LocalDateTime.now();
        orderService.doOrder(date);
        System.out.println("Current time: " + date);
    }
}