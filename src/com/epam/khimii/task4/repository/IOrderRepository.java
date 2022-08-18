package com.epam.khimii.task4.repository;

import com.epam.khimii.task4.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    void doOrder(LocalDateTime date);

    Optional<Order> getOrderByTime(LocalDateTime date);

    List<Order> getOrderByRange(LocalDateTime date1, LocalDateTime date2);
}
