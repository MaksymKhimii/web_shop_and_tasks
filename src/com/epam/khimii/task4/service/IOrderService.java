package com.epam.khimii.task4.service;

import com.epam.khimii.task4.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Optional<Order> findOrderByTime(LocalDateTime date);

    List<Order> findOrderByTimeRange(LocalDateTime date1,
                                     LocalDateTime date2);
}
