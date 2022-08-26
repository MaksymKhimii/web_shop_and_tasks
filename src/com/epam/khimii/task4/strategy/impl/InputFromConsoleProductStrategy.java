package com.epam.khimii.task4.strategy.impl;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.inputFactory.IProductInputData;
import com.epam.khimii.task4.parts.constants.Constants;
import com.epam.khimii.task4.container.ProductInputDataContainer;
import com.epam.khimii.task4.strategy.InputProductStrategy;

import java.util.Scanner;

/**
 * Get type of input product from console
 * and use appropriate class to fill product container.
 */
public class InputFromConsoleProductStrategy implements InputProductStrategy {
    private Scanner scanner;
    private ProductInputDataContainer container;

    public InputFromConsoleProductStrategy(Scanner scanner) {
        this.scanner = scanner;
        container = new ProductInputDataContainer(scanner);
    }

    public Product generateProduct() {
        IProductInputData strategy = container.getInputData(getType());
        return strategy.inputDataFromConsole();
    }

    private int getType() {
        System.out.println(Constants.INPUT_TYPE_PRODUCT);
        container.getInputDataMap().forEach((k, v) -> System.out.println(k + " - " + v));
        return (scanner.nextInt());
    }
}

