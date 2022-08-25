package com.epam.khimii.task4.factory_input_data;

import com.epam.khimii.task1.entity.GraphicsCard;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;

import java.util.Scanner;

public class GraphicsCardInputData extends ComputerPartInputData {
    public GraphicsCardInputData(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Product inputDataFromConsole() {
        System.out.println(Constants.INPUT_MEMORY);
        int memory = scanner.nextInt();
        System.out.println(Constants.INPUT_MEMORY_TYPE);
        String memoryType = scanner.nextLine();
        System.out.println(Constants.INPUT_CONNECTOR);
        String connector = scanner.nextLine();
        return new GraphicsCard(super.getName(), super.getPrice(), super.getCountry(),
                super.getCategory(), super.getPurpose(), memory, memoryType, connector);
    }

    @Override
    public String toString() {
        return Constants.GRAPHICS_CARD;
    }
}
