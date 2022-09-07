package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.command.AddProductToList;
import com.epam.khimii.task4.command.AddProductsWithReflectionCommand;
import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.command.AddProdToBasketCommand;
import com.epam.khimii.task4.command.BuyBasketCommand;
import com.epam.khimii.task4.command.DoOrderCommand;
import com.epam.khimii.task4.command.ExitCommand;
import com.epam.khimii.task4.command.NoCommand;
import com.epam.khimii.task4.command.ShowOrderByTimeCommand;
import com.epam.khimii.task4.command.ShowBasketCommand;
import com.epam.khimii.task4.command.ShowBufferCommand;
import com.epam.khimii.task4.command.ShowOrderByTimeRangeCommand;
import com.epam.khimii.task4.command.ShowProductsCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineStore {
    private final Map<String, Command> commands = new HashMap<>();
    private boolean finish = false;
    private final ApplicationContext applicationContext = new ApplicationContext();
    private Scanner scanner;

    public void init() {
            applicationContext.initAll();
        scanner = applicationContext.getScanner();
        commands.put("0", new ExitCommand(applicationContext.getFileHandler(), applicationContext.getProductRepositoryImpl()));
        commands.put("1", new ShowProductsCommand(applicationContext.getProductRepositoryImpl()));
        commands.put("2", new AddProdToBasketCommand(applicationContext.getBasketServiceImpl(),
                applicationContext.getProductService(), scanner));
        commands.put("3", new ShowBasketCommand(applicationContext.getBasketRepositoryImpl()));
        commands.put("4", new BuyBasketCommand(applicationContext.getBasketServiceImpl()));
        commands.put("5", new ShowBufferCommand(applicationContext.getBufferService()));
        commands.put("6", new DoOrderCommand(applicationContext.getOrderServiceImpl()));
        commands.put("7", new ShowOrderByTimeRangeCommand(applicationContext.getOrderServiceImpl(), scanner));
        commands.put("8", new ShowOrderByTimeCommand(applicationContext.getOrderServiceImpl(), scanner));
        commands.put("9", new AddProductToList(applicationContext.getProductService(), applicationContext.getFillStrategyContainer(),
                applicationContext.getScanner()));
        commands.put("10", new AddProductsWithReflectionCommand(applicationContext.getInputAppWithReflection(),
                applicationContext.getProductService()));
    }

    public void choice() {
        init();
        String myChoice;
        while (!finish) {
            System.out.println("Available actions:");
            System.out.println("1 - display a list of products");
            System.out.println("2 - add item to basket");
            System.out.println("3 - view the contents of the basket");
            System.out.println("4 - buy all items from the basket(display the total amount)");
            System.out.println("5 - view information about the last three items in the display");
            System.out.println("6 - make an order");
            System.out.println("7 - find order by time range");
            System.out.println("8 - find order by specified date");
            System.out.println("9 - add item to product's list");
            System.out.println("10 - add some products with reflection");
            System.out.println("0 - Exit ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("What's your choice?");
            myChoice = scanner.nextLine();
            Command command = commands.getOrDefault(myChoice, new NoCommand());
            command.execute();
        }
    }
}