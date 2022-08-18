package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Order;
import com.epam.khimii.task4.repository.IOrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements IOrderService {
    private IOrderRepository orderRepositoryImpl;

    public OrderServiceImpl(IOrderRepository orderRepositoryImpl) {
        this.orderRepositoryImpl = orderRepositoryImpl;
    }

    @Override
    public void doOrder(LocalDateTime date) {
        orderRepositoryImpl.doOrder(date);
    }

    @Override
    public Optional<Order> findOrderByTime(LocalDateTime date) {
        return orderRepositoryImpl.getOrderByTime(date);
    }

    @Override
    public List<Order> findOrderByTimeRange(LocalDateTime dateBefore, LocalDateTime dateAfter) {
        return orderRepositoryImpl.getOrderByRange(dateBefore, dateAfter);
    }


}
