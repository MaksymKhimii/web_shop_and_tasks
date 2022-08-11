package com.epam.khimii.task4.service;

import java.time.LocalDateTime;

public interface IOrderService {
    String findOrderByTime(LocalDateTime date);

    String findOrderByTimeRange(LocalDateTime date1,
                                LocalDateTime date2);
}
