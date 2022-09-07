package com.epam.khimii.task4.inputFactory;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Input data from console to create product.
 * Use pattern "factory".
 */
public class ProductInputData implements IProductInputData {
    public Scanner scanner;

    public ProductInputData(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getName() {
        System.out.println(Constants.INPUT_NAME);
        return scanner.nextLine();
    }

    public BigDecimal getPrice() {
        System.out.println(Constants.INPUT_PRICE);
        return new BigDecimal(scanner.nextLine());
    }

    public String getCountry() {
        System.out.println(Constants.INPUT_COUNTRY);
        return scanner.nextLine();
    }

    public Product inputDataFromConsole() {
        return new Product(getName(), getPrice(), getCountry());
    }

    @Override
    public String toString() {
        return Constants.PRODUCT;
    }
}
