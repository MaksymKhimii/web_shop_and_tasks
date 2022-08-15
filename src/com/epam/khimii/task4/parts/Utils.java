package com.epam.khimii.task4.parts;

import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.entity.Product;

import java.util.List;
import java.util.Optional;

public class Utils {
    public static void printProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("В нашей базе нет продуктов(");
            return;
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static void printBasket(Basket basket) {
        if (basket.isEmpty()) {
            System.out.println("В нашей базе нет продуктов(");
            return;
        }
        System.out.println(basket);
    }

    public static void printBuffer(Buffer buffer) {
        if (buffer.isEmpty()) {
            System.out.println("В буфер нет продуктов(");
            return;
        }
        System.out.println(buffer);
    }

    public static void printOrder(Optional<Order> order) {
        if (order.isEmpty()) {
            System.out.println("Заказ не был найден(");
            return;
        }
        System.out.println(order);
    }

    public static void printOrdersByRange(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("Ничего не было найдено(");
            return;
        }
        System.out.println(orders);
    }
}
