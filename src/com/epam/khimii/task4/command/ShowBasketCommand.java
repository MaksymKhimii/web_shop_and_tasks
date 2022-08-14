package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;

public class ShowBasketCommand implements Command {
    Utils utils = new Utils();

    @Override
    public void execute() {
        System.out.println("Products in the basket:");
        utils.printBasket();
    }
}