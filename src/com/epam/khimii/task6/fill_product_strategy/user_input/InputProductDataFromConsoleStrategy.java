package com.epam.khimii.task6.fill_product_strategy.user_input;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;
import com.epam.khimii.task6.constants.Constants;
import com.epam.khimii.task6.container.ProductInputDataContainer;
import com.epam.khimii.task6.factory_input_data.ProductInputData;
import com.epam.khimii.task6.fill_product_strategy.FillProductDataStrategy;

import java.util.Scanner;

import static com.epam.khimii.task6.AddingProductsToCatalog.scanner;

/**
 * Get type of input product from console
 * and use appropriate class to fill product container.
 */
public class InputProductDataFromConsoleStrategy implements FillProductDataStrategy {
    public UniqueProductArrayList<Product> fill(int size) {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();
        for (int i = 0; i < size; ++i) {
            ProductInputData strategy = this.getInputStrategy();
            products.add(strategy.inputDataFromConsole());
        }
        return products;
    }

    private ProductInputData getInputStrategy() {
        System.out.println(Constants.INPUT_TYPE_PRODUCT);
        ProductInputDataContainer container = new ProductInputDataContainer();
        container.getInputDataMap().forEach((k, v) -> System.out.println(k + " - " + v));
        int code = (scanner.nextInt());
        return container.getInputData(code);
    }
}

