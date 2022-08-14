package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;

public class ShowProductsCommand implements Command {
    Utils utils = new Utils();

    @Override
    public void execute() {
        System.out.println("Available Products: ");
        utils.printProducts();
    }
}
