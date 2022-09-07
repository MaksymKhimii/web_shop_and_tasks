package com.epam.khimii.task4.reflection;

import com.epam.khimii.task1.entity.Product;

import java.lang.reflect.InvocationTargetException;

public class InputWithReflection {
    public Product addProduct() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        InputOutputData inputOutputData = new InputOutputData();
        Resource resource = chooseLanguage(inputOutputData);
        return new InputProductDataFromConsole(inputOutputData, resource).createProduct();
    }

    private Resource chooseLanguage(InputOutputData inputOutputData) {
        return new Resource(inputOutputData.getInput("Input language(en/ru)"));
    }
}