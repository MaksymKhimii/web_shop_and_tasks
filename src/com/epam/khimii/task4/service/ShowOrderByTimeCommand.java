package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ShowOrderByTimeCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Введите дату заказа:");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        OrderRepository.getOrderByTime(date);
    }
}