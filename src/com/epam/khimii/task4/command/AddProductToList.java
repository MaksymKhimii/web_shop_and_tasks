package com.epam.khimii.task4.command;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.container.FillStrategyContainer;
import com.epam.khimii.task4.parts.InputCheck;
import com.epam.khimii.task4.service.IProductService;
import com.epam.khimii.task4.strategy.InputProductStrategy;

import java.util.Scanner;

public class AddProductToList implements Command {
    private Scanner scanner;
    private IProductService productService;
    private FillStrategyContainer fillStrategyContainer;

    public AddProductToList(IProductService productService, FillStrategyContainer fillStrategyContainer,
                            Scanner scanner) {
        this.productService = productService;
        this.fillStrategyContainer = fillStrategyContainer;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Choose type of input of date: console input or generate data (0/1)");
        int code = InputCheck.getStrategyCodeNumber(scanner);
        if (code == -1) {
            System.out.println("Wrong strategy(");
            return;
        }
        InputProductStrategy strategy = fillStrategyContainer.getStrategies(code);
        Product newProd = strategy.generateProduct();
        System.out.println("Command prod: " + newProd);
        productService.addProdToList(newProd);
        if (productService.isExists(newProd)) {
            System.out.println("The new product has been added successfully!");
            return;
        }
        System.out.println("Adding error(");
    }
}