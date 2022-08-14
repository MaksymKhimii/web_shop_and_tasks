package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.command.AddProdToBasketCommand;
import com.epam.khimii.task4.command.BuyBasketCommand;
import com.epam.khimii.task4.command.DoOrderCommand;
import com.epam.khimii.task4.command.ShowOrderByTimeCommand;
import com.epam.khimii.task4.command.ShowBasketCommand;
import com.epam.khimii.task4.command.ShowBufferCommand;
import com.epam.khimii.task4.command.ShowOrderByTimeRangeCommand;
import com.epam.khimii.task4.command.ShowProductsCommand;

import java.util.HashMap;
import java.util.Map;

import static com.epam.khimii.task4.parts.InputCheck.check;

public class OnlineStore {
    private final Map<Integer, Command> commands = new HashMap<>();
    private boolean finish = false;
    ApplicationContext applicationContext = new ApplicationContext();

    public void init() {
        applicationContext.initAll();
        commands.put(1, new ShowProductsCommand());
        commands.put(2, new AddProdToBasketCommand(applicationContext.getBasketRepository(), applicationContext.getProductRepository()));
        commands.put(3, new ShowBasketCommand());
        commands.put(4, new BuyBasketCommand());
        commands.put(5, new ShowBufferCommand());
        commands.put(6, new DoOrderCommand());
        commands.put(7, new ShowOrderByTimeRangeCommand());
        commands.put(8, new ShowOrderByTimeCommand());
    }

    public void choice() {
        init();
        int myChoice;
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
            myChoice = check();
            if (myChoice == 0) {
                break;
            }
            Command command = commands.get(myChoice);
            command.execute();
        }
    }
}
