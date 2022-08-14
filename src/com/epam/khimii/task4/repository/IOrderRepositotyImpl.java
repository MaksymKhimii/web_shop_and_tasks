package com.epam.khimii.task4.repository;

import java.time.LocalDateTime;
import java.util.Map;

public interface IOrderRepositotyImpl {
    void doOrder(LocalDateTime date);

    Map<String, Integer> getOrderByTime(LocalDateTime date);

    Map<String, Integer> getOrderByRange(LocalDateTime date1, LocalDateTime date2);
}
