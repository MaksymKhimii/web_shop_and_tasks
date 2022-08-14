package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.controller.ApplicationContext;
import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.repository.IOrderRepositotyImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class OrderRepository implements IOrderRepositotyImpl {
    ApplicationContext applicationContext = new ApplicationContext();
    private static HashMap<String, Integer> orders = new HashMap<>();
    private Basket basket = applicationContext.getBasket();
    private Order order = applicationContext.getOrder();


    @Override
    public void doOrder(LocalDateTime date) {
        orders.putAll(basket.getBasket());
        order.put(date, orders);
    }

    @Override
    public Map<String, Integer> getOrderByRange(LocalDateTime date1, LocalDateTime date2) {
        Map<String, Integer> neededOrder;
        for (Map.Entry<LocalDateTime, Map<String, Integer>> entry : order.entrySet()) {
            if (entry.getKey().isAfter(date1) && entry.getKey().isBefore(date2)) {
                neededOrder = entry.getValue();
                return neededOrder;
            }
        }
        return null;
    }

    @Override
    public Map<String, Integer> getOrderByTime(LocalDateTime date) {
        Map<String, Integer> neededOrder;
        for (Map.Entry<LocalDateTime, Map<String, Integer>> entry : order.entrySet()) {
            if (date.equals(entry.getKey())) {
                neededOrder = entry.getValue();
                return neededOrder;
            }
        }
        return null;
    }
}
