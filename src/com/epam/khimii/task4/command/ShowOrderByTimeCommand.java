package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.service.OrderServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ShowOrderByTimeCommand implements Command {
    Scanner scanner = new Scanner(System.in);
    public static OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    @Override
    public void execute() {
        System.out.println("Введите дату заказа:");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Order: ");
        System.out.println(orderServiceImpl.findOrderByTime(date));
    }
}