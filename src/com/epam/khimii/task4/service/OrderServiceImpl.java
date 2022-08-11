package com.epam.khimii.task4.service;

import com.epam.khimii.task4.repository.impl.OrderRepositoryImpl;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderServiceImpl implements IOrderService {
    public static OrderRepositoryImpl orderRepositoryImpl = new OrderRepositoryImpl();

    @Override
    public String findOrderByTime(LocalDateTime date) {
        HashMap<String, Integer> neededOrder = orderRepositoryImpl.getOrderByTime(date);
        if (neededOrder != null) {
            return neededOrder.toString();
        }
        return "Order for the specified time was not found";
    }

    @Override
    public String findOrderByTimeRange(LocalDateTime date1, LocalDateTime date2) {
        HashMap<String, Integer> neededOrder = orderRepositoryImpl.getOrderByRange(date1, date2);
        if (neededOrder != null) {
            return neededOrder.toString();
        }
        return "Order for the specified time range was not found";
    }
}
