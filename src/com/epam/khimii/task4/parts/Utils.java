package com.epam.khimii.task4.parts;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Buffer;
import com.epam.khimii.task4.entity.Order;


import java.util.List;
import java.util.Optional;

public class Utils {
    public static void printProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("There are no products in our database(");
            return;
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static void printBasket(Basket basket) {
        if (basket.isEmpty()) {
            System.out.println("There are no products in our basket(");
            return;
        }
        System.out.println(basket);
    }

    public static void printBuffer(Buffer buffer) {
        if (buffer.isEmpty()) {
            System.out.println("There are no products in the buffer(");
            return;
        }
        System.out.println(buffer);
    }

    public static void printOrder(Optional<Order> order) {
        if (order.isEmpty()) {
            System.out.println("Order not found(");
            return;
        }
        System.out.println(order);
    }

    public static void printOrdersByRange(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("Nothing was found(");
            return;
        }
        System.out.println(orders);
    }
}
