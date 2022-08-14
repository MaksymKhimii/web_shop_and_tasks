package com.epam.khimii.task4.command;

import com.epam.khimii.task4.service.BasketService;

public class BuyBasketCommand implements Command {
    BasketService basketService = new BasketService();

    @Override
    public void execute() {
        if (basketService.getBasketSum() == -1) {
            System.out.println("Basket is empty, you can't buy it");
            return;
        }
        System.out.println("The total amount of the order: " + basketService.buyBasket());
    }
}