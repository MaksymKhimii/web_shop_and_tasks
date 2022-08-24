package com.epam.khimii.task4.factory_input_data;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Input data from console to create product.
 * Use pattern "factory".
 */
public class ProductInputData {
    public Scanner scanner = new Scanner(System.in);

    public Product inputDataFromConsole() {
        System.out.println(Constants.INPUT_NAME);
        String name = scanner.nextLine();
        System.out.println(Constants.INPUT_PRICE);
        String price = scanner.nextLine();
        System.out.println(Constants.INPUT_COUNTRY);
        String country = scanner.nextLine();
        return new Product(name, new BigDecimal(price), country);
    }

    @Override
    public String toString() {
        return Constants.PRODUCT;
    }
}
