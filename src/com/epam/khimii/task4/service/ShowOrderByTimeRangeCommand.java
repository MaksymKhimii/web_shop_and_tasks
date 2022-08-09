package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ShowOrderByTimeRangeCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Введите диапазон заказа(две даты с новой строки):");
        LocalDateTime date1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime date2 = LocalDateTime.parse(scanner.nextLine());
        OrderRepository.getOrderByRange(date1, date2);
    }
}