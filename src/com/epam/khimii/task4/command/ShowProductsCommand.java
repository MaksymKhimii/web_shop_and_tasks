package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;

public class ShowProductsCommand implements Command {
    ProductRepositoryImpl productRepository;

    public ShowProductsCommand(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute() {
        System.out.println("Available Products: ");
        Utils.printProducts(productRepository.getProducts());
    }
}
