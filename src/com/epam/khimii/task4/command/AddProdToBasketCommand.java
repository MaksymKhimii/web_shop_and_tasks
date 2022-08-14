package com.epam.khimii.task4.command;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.repository.impl.BasketRepository;
import com.epam.khimii.task4.repository.impl.ProductRepository;

import java.util.Scanner;


public class AddProdToBasketCommand implements Command {
    ApplicationContext applicationContext = new ApplicationContext();
    Scanner scanner = applicationContext.getScanner();
    BasketRepository basketRepository;
    ProductRepository productRepository;

    public AddProdToBasketCommand(BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void execute() {
        System.out.println("Enter the product name:");
        String name = scanner.nextLine();
        System.out.println("Enter the quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (!productRepository.isExists(name)) {
            System.out.println("This product does not exist in our database(");
            return;
        }
        basketRepository.addToBasket(name, quantity);
    }
}
