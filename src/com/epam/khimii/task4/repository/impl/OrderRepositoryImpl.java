package com.epam.khimii.task4.repository.impl;

import com.epam.khimii.task4.entity.Basket;
import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.repository.IOrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderRepositoryImpl implements IOrderRepository {
    private List<Order> orders = new ArrayList<>();
    private Basket basket;

    public OrderRepositoryImpl(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void doOrder(LocalDateTime date) {
        orders.add(new Order(date, basket.getBasket()));
    }

    @Override
    public List<Order> getOrderByRange(LocalDateTime date1, LocalDateTime date2) {
        List<Order> neededOrder = new ArrayList<>();
        for (Order entry : orders) {
            if (entry.getDate().isAfter(date1) && entry.getDate().isBefore(date2)) {
                neededOrder.add(entry);
                return neededOrder;
            }
        }
        return null;
    }

    @Override
    public Optional<Order> getOrderByTime(LocalDateTime date) {
        Order neededOrder;
        for (Order entry : orders) {
            if (date.equals(entry.getDate())) {
                neededOrder = entry;
                return Optional.of(neededOrder);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "OrderRepositoryImpl{" +
                "orders=" + orders +
                '}';
    }
}
