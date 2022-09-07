package com.epam.khimii.task4.inputFactory;

import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;

import java.util.Scanner;

public class ComputerPartInputData extends ProductInputData {
    public ComputerPartInputData(Scanner scanner) {
        super(scanner);
    }

    public String getCategory() {
        System.out.println(Constants.INPUT_CATEGORY);
        return scanner.nextLine();
    }

    public String getPurpose() {
        System.out.println(Constants.INPUT_PURPOSE);
        return scanner.nextLine();
    }

    @Override
    public Product inputDataFromConsole() {
        return new ComputerPart(super.getName(), super.getPrice(), super.getCountry(), getCategory(), getPurpose());
    }

    @Override
    public String toString() {
        return Constants.COMPUTER_PART;
    }
}