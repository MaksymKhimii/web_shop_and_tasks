package com.epam.khimii.task9;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.fileHandler.FileHandler;

import java.util.List;

public class ProductLoader {
    public static List<Product> load() {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.load();
    }
}