package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.service.BasketService;

public class BuyBasketCommand implements Command {
    @Override
    public void execute() {
        System.out.println(BasketService.buyBasket());
    }
}