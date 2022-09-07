package com.epam.khimii.task4.reflection;

import com.epam.khimii.task1.entity.Product;

import java.lang.reflect.InvocationTargetException;

public class InputProductDataFromConsole {
    private final InputOutputData inputOutputData;
    private final Resource resource;

    public InputProductDataFromConsole(InputOutputData inputOutputData, Resource resource) {
        this.inputOutputData = inputOutputData;
        this.resource = resource;
    }

    public Product createProduct() throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<? extends Product> prod = getProductClass();
        ProductFieldReflection fieldReflection = new ProductFieldReflection();
        return fieldReflection.fillProduct(prod, resource);
    }

    private Class<? extends Product> getProductClass() {
        ProductClassesContainer productContainer = new ProductClassesContainer();
        StringBuilder classes = new StringBuilder();
        productContainer.getClasses().forEach((k, v) -> classes.append(k).append('-').append(v.getSimpleName()).append('\n'));
        return productContainer.getClassByCode(inputOutputData.inputCodeOfProductClass(classes.toString()));
    }
}