package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.service.OrderServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ShowOrderByTimeRangeCommand implements Command {
    Scanner scanner = new Scanner(System.in);
    public static OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    @Override
    public void execute() {
        System.out.println("Введите диапазон заказа(две даты с новой строки):");
        LocalDateTime date1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime date2 = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Order: ");
        System.out.println(orderServiceImpl.findOrderByTimeRange(date1, date2));
    }
}