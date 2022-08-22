package com.epam.khimii.task6.container;

import com.epam.khimii.task6.constants.Constants;
import com.epam.khimii.task6.factory_input_data.AccessoriesInputData;
import com.epam.khimii.task6.factory_input_data.ComputerPartInputData;
import com.epam.khimii.task6.factory_input_data.GraphicsCardInputData;
import com.epam.khimii.task6.factory_input_data.ProductInputData;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains map of ProductInputData.
 * @see ProductInputData
 */
public class ProductInputDataContainer {
    private final Map<Integer, ProductInputData> inputDataMap = new HashMap<>();

    public ProductInputDataContainer() {
        inputDataMap.put(Constants.PRODUCT_INPUT_DATA_NUMBER, new ProductInputData());
        inputDataMap.put(Constants.COMPUTER_PART_INPUT_DATA_NUMBER, new ComputerPartInputData());
        inputDataMap.put(Constants.ACCESSORIES_INPUT_DATA_NUMBER, new AccessoriesInputData());
        inputDataMap.put(Constants.GRAPHICS_CARD_INPUT_DATA_NUMBER, new GraphicsCardInputData());
    }

    public Map<Integer, ProductInputData> getInputDataMap() {
        return inputDataMap;
    }

    public ProductInputData getInputData(int code) {
        return !inputDataMap.containsKey(code) ? new ProductInputData() : inputDataMap.get(code);
    }
}
