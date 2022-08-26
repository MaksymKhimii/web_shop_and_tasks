package com.epam.khimii.task4.container;

import com.epam.khimii.task4.parts.constants.Constants;
import com.epam.khimii.task4.inputFactory.AccessoriesInputData;
import com.epam.khimii.task4.inputFactory.ComputerPartInputData;
import com.epam.khimii.task4.inputFactory.GraphicsCardInputData;
import com.epam.khimii.task4.inputFactory.ProductInputData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Contains map of ProductInputData.
 *
 * @see ProductInputData
 */
public class ProductInputDataContainer {
    private Scanner scanner;

    private final Map<Integer, ProductInputData> inputDataMap = new HashMap<>() {{
        put(Constants.PRODUCT_INPUT_DATA_NUMBER, new ProductInputData(scanner));
        put(Constants.COMPUTER_PART_INPUT_DATA_NUMBER, new ComputerPartInputData(scanner));
        put(Constants.ACCESSORIES_INPUT_DATA_NUMBER, new AccessoriesInputData(scanner));
        put(Constants.GRAPHICS_CARD_INPUT_DATA_NUMBER, new GraphicsCardInputData(scanner));
    }};

    public ProductInputDataContainer(Scanner scanner) {
        this.scanner = scanner;
    }

    public Map<Integer, ProductInputData> getInputDataMap() {
        return inputDataMap;
    }

    public ProductInputData getInputData(int code) {
        return !inputDataMap.containsKey(code) ? new ProductInputData(scanner) : inputDataMap.get(code);
    }
}