package com.epam.khimii.task4.container;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.strategy.InputProductStrategy;
import com.epam.khimii.task4.strategy.impl.RandomInputProductStrategy;
import com.epam.khimii.task4.strategy.impl.InputFromConsoleProductStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Contains map of FillProductDataStrategy.
 * @see InputProductStrategy
 */
public class FillStrategyContainer {
    private final Map<Integer, InputProductStrategy> strategies = new HashMap();
    private Scanner scanner;

    public FillStrategyContainer(List<Product> products, Scanner scanner) {
        this.scanner = scanner;
        this.strategies.put(0, new InputFromConsoleProductStrategy(scanner));
        this.strategies.put(1, new RandomInputProductStrategy(products));
    }

    public InputProductStrategy getStrategies(int code) {
        return this.strategies.get(code);
    }
}