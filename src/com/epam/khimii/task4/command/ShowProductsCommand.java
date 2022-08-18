package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.Utils;
import com.epam.khimii.task4.repository.IProductRepository;

public class ShowProductsCommand implements Command {
    private IProductRepository productRepository;

    public ShowProductsCommand(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute() {
        System.out.println("Available Products: ");
        Utils.printProducts(productRepository.getProducts());
    }
}
