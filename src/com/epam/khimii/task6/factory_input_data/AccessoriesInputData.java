package com.epam.khimii.task6.factory_input_data;

import com.epam.khimii.task1.entity.Accessory;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task6.constants.Constants;

import java.util.Scanner;

import static com.epam.khimii.task6.AddingProductsToCatalog.scanner;

public class AccessoriesInputData extends ProductInputData {
    @Override
    public Product inputDataFromConsole() {
        Product p = super.inputDataFromConsole();
        System.out.println(Constants.INPUT_TYPE);
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
