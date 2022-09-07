package com.epam.khimii.task4.strategy;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task3.list.UniqueProductArrayList;
import com.epam.khimii.task4.container.FillStrategyContainer;
import com.epam.khimii.task4.fileHandler.FileHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class InputProductStrategyTest {
    private final Scanner scanner = new Scanner(System.in);
    private UniqueProductArrayList<Product> products;

    @Before
    public void Before() {
        products = new UniqueProductArrayList<>();
        products.addAll(new FileHandler().load());
    }

    @Test
    public void shouldFillNewRandomGoodsTest() {
        InputProductStrategy strategy = (new FillStrategyContainer(scanner)).getStrategies(1);
        Product newProd = strategy.generateProduct();
        products.add(newProd);
        new FileHandler().save(products);
        Assert.assertEquals(6, products.size());
    }
}
