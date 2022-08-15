package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;

public class ShowBasketCommand implements Command {
    BasketRepositoryImpl basketRepository;

    public ShowBasketCommand(BasketRepositoryImpl basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void execute() {
        System.out.println("Products in the basket:");
        Utils.printBasket(basketRepository.getBasket());
    }
}