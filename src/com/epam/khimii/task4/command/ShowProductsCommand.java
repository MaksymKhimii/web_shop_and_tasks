package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.service.ProductService;

public class ShowProductsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Доступные продукты: ");
        System.out.println(ProductService.printProducts());
    }
}
