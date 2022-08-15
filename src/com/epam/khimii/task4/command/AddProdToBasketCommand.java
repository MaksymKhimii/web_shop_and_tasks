package com.epam.khimii.task4.command;

import com.epam.khimii.task4.repository.impl.BasketRepositoryImpl;
import com.epam.khimii.task4.repository.impl.ProductRepositoryImpl;

import java.util.Scanner;


public class AddProdToBasketCommand implements Command {
    Scanner scanner;
    BasketRepositoryImpl basketRepositoryImpl;
    ProductRepositoryImpl productRepositoryImpl;

    public AddProdToBasketCommand(BasketRepositoryImpl basketRepositoryImpl, ProductRepositoryImpl productRepositoryImpl,
                                  Scanner scanner) {
        this.basketRepositoryImpl = basketRepositoryImpl;
        this.productRepositoryImpl = productRepositoryImpl;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter the product name:");
        String name = scanner.nextLine();
        System.out.println("Enter the quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (!productRepositoryImpl.isExists(name)) {
            System.out.println("This product does not exist in our database(");
            return;
        }
        basketRepositoryImpl.addToBasket(name, quantity);
    }
}
