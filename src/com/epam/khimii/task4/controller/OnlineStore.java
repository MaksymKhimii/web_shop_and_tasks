package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.command.AddProdToBasketCommand;
import com.epam.khimii.task4.command.BuyBasketCommand;
import com.epam.khimii.task4.command.DoOrderCommand;
import com.epam.khimii.task4.command.ExitCommand;
import com.epam.khimii.task4.command.ShowOrderByTimeCommand;
import com.epam.khimii.task4.command.ShowBasketCommand;
import com.epam.khimii.task4.command.ShowBufferCommand;
import com.epam.khimii.task4.command.ShowOrderByTimeRangeCommand;
import com.epam.khimii.task4.command.ShowProductsCommand;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static com.epam.khimii.task4.parts.InputValidation.check;

public class OnlineStore {
    private static final Map<Integer, Command> commands = new HashMap<>();
    public static boolean finish = false;

    public static void init() {
        ProductRepositoryImpl.initProduct();
        commands.put(0, new ExitCommand());
        commands.put(1, new ShowProductsCommand());
        commands.put(2, new AddProdToBasketCommand());
        commands.put(3, new ShowBasketCommand());
        commands.put(4, new BuyBasketCommand());
        commands.put(5, new ShowBufferCommand());
        commands.put(6, new DoOrderCommand());
        commands.put(7, new ShowOrderByTimeRangeCommand());
        commands.put(8, new ShowOrderByTimeCommand());
    }

    public static void choice() {
        init();
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
            System.out.println("0 - Exit ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("What's your choice?");
            int myChoice = check();
            Command command = commands.get(myChoice);
            command.execute();
        }
    }
}
