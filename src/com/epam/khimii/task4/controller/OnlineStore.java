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
import java.util.Scanner;

import static com.epam.khimii.task4.parts.InputCheck.check;

public class OnlineStore {
    private final Map<Integer, Command> commands = new HashMap<>();
    private boolean finish = false;
    ApplicationContext applicationContext = new ApplicationContext();
    Scanner scanner;

    public void init() {
        applicationContext.initAll();
        scanner = new Scanner(System.in);
        commands.put(1, new ShowProductsCommand(applicationContext.getProductRepository()));
        commands.put(2, new AddProdToBasketCommand(applicationContext.getBasketRepository(),
                applicationContext.getProductRepository(), scanner));
        commands.put(3, new ShowBasketCommand(applicationContext.getBasketRepository()));
        commands.put(4, new BuyBasketCommand(applicationContext.getBasketService()));
        commands.put(5, new ShowBufferCommand(applicationContext.getBufferRepository()));
        commands.put(6, new DoOrderCommand(applicationContext.getOrderRepository()));
        commands.put(7, new ShowOrderByTimeRangeCommand(applicationContext.getOrderService(), scanner));
        commands.put(8, new ShowOrderByTimeCommand(applicationContext.getOrderService(), scanner));
    }

    public void choice() {
        init();
        String myChoice;
        int action;
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
            myChoice = scanner.nextLine();
            action = check(myChoice);
            if (action == 0) {
                break;
            }
            if (action == -1) {
                System.out.println("Wrong input!");
            } else {
                Command command = commands.get(action);
                command.execute();
            }
        }
    }
}
