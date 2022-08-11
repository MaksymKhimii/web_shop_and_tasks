package com.epam.khimii.task4.repository;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface IOrderRepositoty {
    void doOrder(LocalDateTime date);

    HashMap<String, Integer> getOrderByTime(LocalDateTime date);

    HashMap<String, Integer> getOrderByRange(LocalDateTime date1, LocalDateTime date2);
}
