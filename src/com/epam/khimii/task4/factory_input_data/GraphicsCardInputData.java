package com.epam.khimii.task4.factory_input_data;


import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.GraphicsCard;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;

public class GraphicsCardInputData extends ComputerPartInputData {
    @Override
    public Product inputDataFromConsole() {
        ComputerPart p = (ComputerPart) super.inputDataFromConsole();
        System.out.println(Constants.INPUT_MEMORY);
        int memory = scanner.nextInt();
        System.out.println(Constants.INPUT_MEMORY_TYPE);
        String memoryType = scanner.nextLine();
        System.out.println(Constants.INPUT_CONNECTOR);
        String connector = scanner.nextLine();
        return new GraphicsCard(p.getName(), p.getPrice(), p.getCountry(), p.getCategory(), p.getPurpose(), memory, memoryType, connector);
    }

    @Override
    public String toString() {
        return Constants.GRAPHICS_CARD;
    }
}
