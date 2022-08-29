package com.epam.khimii.task4.command;

import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.parts.InputCheck;
import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.service.IOrderService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;


public class ShowOrderByTimeCommand implements Command {
    private IOrderService orderServiceImpl;
    private Scanner scanner;

    public ShowOrderByTimeCommand(IOrderService orderServiceImpl, Scanner scanner) {
        this.orderServiceImpl = orderServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter order date:");
        LocalDateTime date = InputCheck.getInputTime(scanner);
        if (date == null) {
            System.out.println("Wrong input!");
            return;
        }
        Optional<Order> neededOrder = orderServiceImpl.findOrderByTime(date);
        if (neededOrder.isEmpty()) {
            System.out.println("Order for the specified time was not found");
            return;
        }
        System.out.println("Order: ");
        Utils.printOrder(neededOrder);
    }
}