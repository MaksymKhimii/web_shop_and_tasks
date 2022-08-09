package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.BasketRepository;

import java.util.Scanner;

public class AddProdToBasketCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();
        System.out.println("Введите колличество:");
        int quantity = Integer.parseInt(scanner.nextLine());
        BasketRepository.addToBasket(name, quantity);
    }
}
