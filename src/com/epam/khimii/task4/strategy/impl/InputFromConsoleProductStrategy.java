package com.epam.khimii.task4.strategy.impl;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;
import com.epam.khimii.task4.container.ProductInputDataContainer;
import com.epam.khimii.task4.factory_input_data.ProductInputData;
import com.epam.khimii.task4.strategy.InputProductStrategy;

import java.util.List;
import java.util.Scanner;

/**
 * Get type of input product from console
 * and use appropriate class to fill product container.
 */
public class InputFromConsoleProductStrategy implements InputProductStrategy {
    private ProductInputDataContainer container = new ProductInputDataContainer();
    private Scanner scanner;

    public InputFromConsoleProductStrategy(Scanner scanner) {
        this.scanner = scanner;
    }


    public Product generateProduct(List<Product> products) {
        ProductInputData strategy = container.getInputData(getType());
        return strategy.inputDataFromConsole();
    }

    @Override
    public int getType() {
        System.out.println(Constants.INPUT_TYPE_PRODUCT);
        container.getInputDataMap().forEach((k, v) -> System.out.println(k + " - " + v));
        int code = (scanner.nextInt());
        return code;
    }
}

