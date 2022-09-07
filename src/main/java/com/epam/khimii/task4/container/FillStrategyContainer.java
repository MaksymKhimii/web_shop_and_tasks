package com.epam.khimii.task4.container;

import com.epam.khimii.task4.strategy.InputProductStrategy;
import com.epam.khimii.task4.strategy.impl.RandomInputProductStrategy;
import com.epam.khimii.task4.strategy.impl.InputFromConsoleProductStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Contains map of FillProductDataStrategy.
 * @see InputProductStrategy
 */
public class FillStrategyContainer {
    private final Map<Integer, InputProductStrategy> strategies = new HashMap();

    public FillStrategyContainer(Scanner scanner) {
        this.strategies.put(0, new InputFromConsoleProductStrategy(scanner));
        this.strategies.put(1, new RandomInputProductStrategy());
    }

    public InputProductStrategy getStrategies(int code) {
        return this.strategies.get(code);
    }
}