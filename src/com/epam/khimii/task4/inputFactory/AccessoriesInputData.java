package com.epam.khimii.task4.inputFactory;

import com.epam.khimii.task1.entity.Accessory;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;

import java.util.Scanner;


public class AccessoriesInputData extends ProductInputData {
    public AccessoriesInputData(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Product inputDataFromConsole() {
        String type = scanner.nextLine();
        System.out.println(Constants.INPUT_BRAND);
        String brand = scanner.nextLine();
        return new Accessory(super.getName(), super.getPrice(), super.getCountry(), type, brand);
    }

    @Override
    public String toString() {
        return Constants.ACCESSORIES;
    }
}