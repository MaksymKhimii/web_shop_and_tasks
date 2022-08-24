package com.epam.khimii.task4.factory_input_data;

import com.epam.khimii.task1.entity.Accessory;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;


public class AccessoriesInputData extends ProductInputData {
    @Override
    public Product inputDataFromConsole() {
        Product p = super.inputDataFromConsole();
        String type = scanner.nextLine();
        System.out.println(Constants.INPUT_BRAND);
        String brand = scanner.nextLine();
        return new Accessory(p.getName(), p.getPrice(), p.getCountry(), type, brand);
    }

    @Override
    public String toString() {
        return Constants.ACCESSORIES;
    }
}
