package com.epam.khimii.task4.command;

import com.epam.khimii.task4.parts.InputCheck;
import com.epam.khimii.task4.service.IBasketService;
import com.epam.khimii.task4.service.IProductService;

import java.util.Scanner;


public class AddProdToBasketCommand implements Command {
    private Scanner scanner;
    private IBasketService basketServiceImpl;
    private IProductService productServiceImpl;

    public AddProdToBasketCommand(IBasketService basketServiceImpl, IProductService productServiceImpl,
                                  Scanner scanner) {
        this.basketServiceImpl = basketServiceImpl;
        this.productServiceImpl = productServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter the product name:");
        String name = scanner.nextLine();
        if (!productServiceImpl.isProduct(name)) {
            System.out.println("This product does not exist in our database(");
            return;
        }
        System.out.println("Enter the quantity:");
        int quantity = InputCheck.getNumber(scanner);
        if (quantity == -1) {
            System.out.println("Wrong input");
            return;
        }
        basketServiceImpl.addToBasket(name, quantity);
    }
}
