package com.epam.khimii.task4.command;

import com.epam.khimii.task4.service.BasketServiceImpl;

public class BuyBasketCommand implements Command {
    BasketServiceImpl basketServiceImpl;

    public BuyBasketCommand(BasketServiceImpl basketServiceImpl) {
        this.basketServiceImpl = basketServiceImpl;
    }

    @Override
    public void execute() {
        if (basketServiceImpl.getBasketSum() == -1) {
            System.out.println("Basket is empty, you can't buy it");
            return;
        }
        System.out.println("The total amount of the order: " + basketServiceImpl.buyBasket());
    }
}