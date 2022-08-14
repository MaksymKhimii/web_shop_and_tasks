package com.epam.khimii.task4.command;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.service.OrderService;

import java.time.LocalDateTime;

public class ShowOrderByTimeRangeCommand implements Command {
    ApplicationContext applicationContext = new ApplicationContext();
    public OrderService orderService = applicationContext.getOrderService();

    @Override
    public void execute() {
        System.out.println("Enter the order range (two dates from a new line):");
        LocalDateTime date1 = applicationContext.getTime();
        LocalDateTime date2 = applicationContext.getTime();
        if (orderService.findOrderByTimeRange(date1, date2) == null) {
            System.out.println("Order for the specified time range was not found");
        }
        System.out.println("Order: ");
        System.out.println(orderService.findOrderByTimeRange(date1, date2).toString());
    }
}