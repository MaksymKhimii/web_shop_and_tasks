package com.epam.khimii.task4.entity;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private LocalDateTime date;
    private Map<String, Integer> order;

    public Order(LocalDateTime date, Map<String, Integer> order) {
        this.date = date;
        this.order = order;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", order=" + order +
                '}';
    }
}
