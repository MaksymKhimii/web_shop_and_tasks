package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;

import java.util.Scanner;

public class AddProdToBasketCommand implements Command {
    Scanner scanner = new Scanner(System.in);
    BasketRepositoryImpl basketRepository = new BasketRepositoryImpl();

    @Override
    public void execute() {
        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();
        System.out.println("Введите колличество:");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (!ProductRepositoryImpl.isExists(name)) {
            System.out.println("Такого продукта не существует в нашей базе(");
            return;
        }
        basketRepository.addToBasket(name, quantity);
    }
}
