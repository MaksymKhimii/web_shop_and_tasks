package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.repository.IBasketRepository;

public class ShowBasketCommand implements Command {
    private IBasketRepository basketRepository;

    public ShowBasketCommand(IBasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void execute() {
        System.out.println("Products in the basket:");
        Utils.printBasket(basketRepository.getBasket());
    }
}