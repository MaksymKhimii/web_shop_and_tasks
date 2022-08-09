package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.BasketRepository;

public class ShowBasketCommand implements Command {
    @Override
    public void execute() {
        BasketRepository.printBasket();
    }
}