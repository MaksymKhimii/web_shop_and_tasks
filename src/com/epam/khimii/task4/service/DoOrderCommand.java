package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.OrderRepository;

import java.time.LocalDateTime;

public class DoOrderCommand implements Command {
    @Override
    public void execute() {
        LocalDateTime date = LocalDateTime.now();
        OrderRepository.doOrder(date);
        System.out.println("Текущее время: " + date);
    }
}