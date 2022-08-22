package com.epam.khimii.task6.factory_input_data;

import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task6.constants.Constants;

import java.util.Scanner;

import static com.epam.khimii.task6.AddingProductsToCatalog.scanner;

public class ComputerPartInputData extends ProductInputData {
    @Override
    public Product inputDataFromConsole() {
        Product p = super.inputDataFromConsole();
        System.out.println(Constants.INPUT_CATEGORY);
        String category = scanner.nextLine();
        System.out.println(Constants.INPUT_PURPOSE);
        String purpose = scanner.nextLine();
        return new ComputerPart(p.getName(), p.getPrice(), p.getCountry(), category, purpose);
    }

    @Override
    public String toString() {
        return Constants.COMPUTER_PART;
    }
}

