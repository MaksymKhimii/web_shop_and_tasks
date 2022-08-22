package com.epam.khimii.task6;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;
import com.epam.khimii.task6.container.FillStrategyContainer;
import com.epam.khimii.task6.file_handler.ProductContainerFilesHandler;
import com.epam.khimii.task6.fill_product_strategy.FillProductDataStrategy;

import java.io.IOException;
import java.util.Scanner;

public class AddingProductsToCatalog {
    public static final Scanner scanner = new Scanner(System.in);

    public static void addProducts() throws IOException {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();
        products.addAll(new ProductContainerFilesHandler().load("fileForTask6.txt"));
        System.out.println("Choose type of input of date: console input or generate data (0/1)");
        FillProductDataStrategy strategy = (new FillStrategyContainer()).getStrategies((scanner.nextInt()));
        System.out.println("Input count of products");
        products.addAll(strategy.fill((scanner.nextInt())));
        new ProductContainerFilesHandler().save(products, "fileForTask6Save.txt");
    }
}

