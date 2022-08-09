package com.epam.khimii.task4.controller;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.service.AddProdToBasketCommand;
import com.epam.khimii.task4.service.BuyBasketCommand;
import com.epam.khimii.task4.service.DoOrderCommand;
import com.epam.khimii.task4.service.ExitCommand;
import com.epam.khimii.task4.service.ShowOrderByTimeCommand;
import com.epam.khimii.task4.service.ShowBasketCommand;
import com.epam.khimii.task4.service.ShowBufferCommand;
import com.epam.khimii.task4.service.ShowOrderByTimeRangeCommand;
import com.epam.khimii.task4.service.ShowProductsCommand;

import java.util.HashMap;
import java.util.Map;

import static com.epam.khimii.task4.parts.InputValidation.check;

public class OnlineStore {
    private static final Map<Integer, Command> commands = new HashMap<>();
    public static boolean finish = false;

    public static void init() {
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
            System.out.println("1 - вывести список товаров");
            System.out.println("2 - добавить товар в корзину");
            System.out.println("3 - просмотреть содержимое корзины");
            System.out.println("4 - купить все товары из корзины(Оформить заказ, вывести общую сумму)");
            System.out.println("5 - просмотреть информацию о 5 последних товарах из корзины(5 сеансов)");
            System.out.println("6 - сделать заказ");
            System.out.println("7 - найти заказ по диапазону времени");
            System.out.println("8 - найти заказ по ближайшей дате");
            System.out.println("0 - Выход ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Какой ваш выбор?");
            int myChoice = check();
            Command command = commands.get(myChoice);
            command.execute();
        }
    }
}
