package com.epam.khimii.task4.command;

import com.epam.khimii.task4.fileHandler.FileHandler;
import com.epam.khimii.task4.repository.IProductRepository;

public class ExitCommand implements Command {
    private FileHandler fileHandler;
    private IProductRepository productRepository;

    public ExitCommand(FileHandler fileHandler, IProductRepository productRepository) {
        this.fileHandler = fileHandler;
        this.productRepository = productRepository;
    }

    @Override
    public void execute() {
        fileHandler.save(productRepository.getProducts());
        System.exit(0);
    }
}