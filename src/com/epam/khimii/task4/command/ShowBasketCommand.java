package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.entity.Basket;

public class ShowBasketCommand implements Command {
    public static Basket basket = new Basket();

    @Override
    public void execute() {
        System.out.println("Товары в корзине:");
        System.out.println(basket.toString());
    }
}