package com.epam.khimii.task4.command;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.service.OrderService;

import java.time.LocalDateTime;


public class ShowOrderByTimeCommand implements Command {
    ApplicationContext applicationContext = new ApplicationContext();
    private OrderService orderService = new OrderService();

    @Override
    public void execute() {
        System.out.println("Enter order date:");
        LocalDateTime date = applicationContext.getTime();
        if (orderService.findOrderByTime(date) == null) {
            System.out.println("Order for the specified time was not found");
            return;
        }
        System.out.println("Order: ");
        System.out.println(orderService.findOrderByTime(date).toString());
    }
}