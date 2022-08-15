package com.epam.khimii.task4.command;

import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.service.OrderServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ShowOrderByTimeRangeCommand implements Command {
    public OrderServiceImpl orderServiceImpl;
    Scanner scanner;

    public ShowOrderByTimeRangeCommand(OrderServiceImpl orderServiceImpl, Scanner scanner) {
        this.orderServiceImpl = orderServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter the order range (two dates from a new line):");
        LocalDateTime dateBefore = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime dateAfter = LocalDateTime.parse(scanner.nextLine());
        List<Order> orderByTimeRange = orderServiceImpl.findOrderByTimeRange(dateBefore, dateAfter);
        if (orderByTimeRange.isEmpty()) {
            System.out.println("Order for the specified time range was not found");
        } else {
            System.out.println("Result: ");
            Utils.printOrdersByRange(orderByTimeRange);
        }
    }
}