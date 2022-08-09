package com.epam.khimii.task4.repository;

import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Products;

import java.util.Map;

import static com.epam.khimii.task4.repository.ProductRepository.products;

public class BasketRepository {
    public static final Basket basket = new Basket();

    public static void addToBasket(String name, int quantity) {
        if (!ProductRepository.isExists(name)) {
            System.out.println("Такого продукта не существует в нашей базе(");
            return;
        }
        basket.put(name, quantity);
        BufferRepository.addToBasketBuffer(name, quantity);
    }

    public static int size() {
        return basket.size();
    }

    public static void buyBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто, купить нельзя");
            return;
        }
        double totalSum = 0;
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            if (ProductRepository.isExists(name)) {
                totalSum += quantity * getProductPrice(name);
            }
        }
        basket.clear();
        //System.out.println("Total "+totalSum);
        System.out.println("Общая сумма заказа: " + totalSum);
    }

    private static double getProductPrice(String name) {
        for (Products product : products) {
            if (product.getName().equals(name)) {
                return product.getPrice();
            }
        }
        return -1;
    }

    public static void printBasket() {
        System.out.println("Товары в корзине:");
        if (basket.isEmpty()) {
            System.out.println("Корзина пока что пустая(");
            return;
        }
        Basket.print(basket);
    }
}
