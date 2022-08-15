package com.epam.khimii.task4.parts;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Product;

import java.util.List;

public class Utils {
    ApplicationContext applicationContext = new ApplicationContext();
    List<Product> products = applicationContext.getProducts();
    Basket basket = applicationContext.getBasket();
    Buffer buffer = applicationContext.getBuffer();

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("В нашей базе нет продуктов(");
            return;
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В нашей базе нет продуктов(");
            return;
        }
        System.out.println(basket.toString());
    }


    public void printBuffer() {
        if (buffer.isEmpty()) {
            System.out.println("В буфер нет продуктов(");
            return;
        }
        System.out.println(buffer.toString());
    }
}
