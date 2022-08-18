package com.epam.khimii.task4.command;

import com.epam.khimii.task4.service.IBasketService;

public class BuyBasketCommand implements Command {
    private IBasketService basketServiceImpl;

    public BuyBasketCommand(IBasketService basketServiceImpl) {
        this.basketServiceImpl = basketServiceImpl;
    }

    @Override
    public void execute() {
        double sum = basketServiceImpl.buyBasket();
        if (sum == -1) {
            System.out.println("Basket is empty, you can't buy it");
            return;
        }
        System.out.println("The total amount of the order: " + sum);
    }
}