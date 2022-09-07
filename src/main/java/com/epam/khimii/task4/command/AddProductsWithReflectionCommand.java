package com.epam.khimii.task4.command;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.reflection.InputWithReflection;
import com.epam.khimii.task4.service.IProductService;

import java.lang.reflect.InvocationTargetException;

public class AddProductsWithReflectionCommand implements Command {
    private IProductService productService;
    private InputWithReflection inputWithReflection;

    public AddProductsWithReflectionCommand(InputWithReflection inputWithReflection, IProductService productService) {
        this.inputWithReflection = inputWithReflection;
        this.productService = productService;
    }

    @Override
    public void execute() {
        Product newProduct = null;
        try {
            newProduct = inputWithReflection.addProduct();
        } catch (InvocationTargetException | NoSuchMethodException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        productService.addProdToList(newProduct);
        if (productService.isExists(newProduct)) {
            System.out.println("The new product has been added successfully!");
            System.out.println(newProduct);
            return;
        }
        System.out.println("Adding error(");
    }
}