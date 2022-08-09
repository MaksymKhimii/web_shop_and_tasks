package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.ProductRepository;

public class ShowProductsCommand implements Command {
    @Override
    public void execute() {
        ProductRepository.printProducts();
    }
}
