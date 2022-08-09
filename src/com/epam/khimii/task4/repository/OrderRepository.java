package com.epam.khimii.task4.repository;

import com.epam.khimii.task4.entity.Order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.epam.khimii.task4.entity.Basket.basket;

public class OrderRepository {
    protected static HashMap<String, Integer> orders = new HashMap<>();
    private static final Order order = new Order();

    public static void doOrder(LocalDateTime date) {
        orders.putAll(basket);
        order.put(date, orders);
    }

    public static void getOrderByRange(LocalDateTime date1, LocalDateTime date2) {
        HashMap<String, Integer> neededOrder = new HashMap<>();
        for (Map.Entry<LocalDateTime, HashMap<String, Integer>> entry : order.entrySet()) {
            if (entry.getKey().isAfter(date1) && entry.getKey().isBefore(date2)) {
                neededOrder = entry.getValue();
                break;
            }
        }
        Order.print(neededOrder);
    }

    public static void getOrderByTime(LocalDateTime date) {
        HashMap<String, Integer> neededOrder = new HashMap<>();
        for (Map.Entry<LocalDateTime, HashMap<String, Integer>> entry : order.entrySet()) {
            if (date.equals(entry.getKey())) {
                neededOrder = entry.getValue();
                break;
            }
        }
        Order.print(neededOrder);
    }
}
