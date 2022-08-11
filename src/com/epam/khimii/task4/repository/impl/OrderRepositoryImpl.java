package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.repository.IOrderRepositoty;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.epam.khimii.task4.entity.Basket.basket;

public class OrderRepositoryImpl implements IOrderRepositoty {
    protected static HashMap<String, Integer> orders = new HashMap<>();
    private static final Order order = new Order();

    @Override
    public void doOrder(LocalDateTime date) {
        orders.putAll(basket);
        order.put(date, orders);
    }

    @Override
    public HashMap<String, Integer> getOrderByRange(LocalDateTime date1, LocalDateTime date2) {
        HashMap<String, Integer> neededOrder;
        for (Map.Entry<LocalDateTime, HashMap<String, Integer>> entry : order.entrySet()) {
            if (entry.getKey().isAfter(date1) && entry.getKey().isBefore(date2)) {
                neededOrder = entry.getValue();
                return neededOrder;
            }
        }
        return null;
    }

    @Override
    public HashMap<String, Integer> getOrderByTime(LocalDateTime date) {
        HashMap<String, Integer> neededOrder;
        for (Map.Entry<LocalDateTime, HashMap<String, Integer>> entry : order.entrySet()) {
            if (date.equals(entry.getKey())) {
                neededOrder = entry.getValue();
                return neededOrder;
            }
        }
        return null;
    }
}
