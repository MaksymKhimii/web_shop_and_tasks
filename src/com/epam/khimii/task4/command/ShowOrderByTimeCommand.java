package com.epam.khimii.task4.command;

import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.service.OrderServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;


public class ShowOrderByTimeCommand implements Command {
    private OrderServiceImpl orderServiceImpl;
    Scanner scanner;

    public ShowOrderByTimeCommand(OrderServiceImpl orderServiceImpl, Scanner scanner) {
        this.orderServiceImpl = orderServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter order date:");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        Optional<Order> neededOrder = orderServiceImpl.findOrderByTime(date);
        if (neededOrder.isEmpty()) {
            System.out.println("Order for the specified time was not found");
            return;
        }
        System.out.println("Order: ");
        Utils.printOrder(neededOrder);
    }
}