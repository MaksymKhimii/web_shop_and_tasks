package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.impl.OrderRepository;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderService implements IOrderServiceImpl {
    public static OrderRepository orderRepository = new OrderRepository();

    @Override
    public Map<String, Integer> findOrderByTime(LocalDateTime date) {
        return orderRepository.getOrderByTime(date);
    }

    @Override
    public Map<String, Integer> findOrderByTimeRange(LocalDateTime date1, LocalDateTime date2) {
        return orderRepository.getOrderByRange(date1, date2);
    }
}
